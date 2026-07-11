package com.vhmsoft.launcherios26.features.launcher

import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.LauncherActivityInfo
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Process
import android.os.UserManager
import android.provider.MediaStore
import android.util.LongSparseArray
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutPreferences
import com.vhmsoft.launcherios26.core.Utilities
import com.vhmsoft.launcherios26.core.broadcast.PackageAddedRemovedHandler
import com.vhmsoft.launcherios26.core.database.DatabaseManager
import com.vhmsoft.launcherios26.core.database.model.ApplicationItem
import com.vhmsoft.launcherios26.core.database.model.FolderItem
import com.vhmsoft.launcherios26.core.database.model.LauncherItem
import com.vhmsoft.launcherios26.core.database.model.ShortcutItem
import com.vhmsoft.launcherios26.core.executors.AppExecutors
import com.vhmsoft.launcherios26.core.utils.AppUtils
import com.vhmsoft.launcherios26.core.utils.Constants
import com.vhmsoft.launcherios26.core.utils.GraphicsUtil
import com.vhmsoft.launcherios26.core.utils.MultiHashMap
import com.vhmsoft.launcherios26.core.utils.UserHandle
import com.vhmsoft.launcherios26.features.launcher.tasks.LoadAppsTask
import com.vhmsoft.launcherios26.features.launcher.tasks.LoadDatabaseTask
import com.vhmsoft.launcherios26.features.launcher.tasks.LoadShortcutTask
import com.vhmsoft.launcherios26.features.shortcuts.DeepShortcutManager
import com.vhmsoft.launcherios26.features.shortcuts.ShortcutInfoCompat
import java.text.Collator
import java.util.Arrays
import java.util.Collections
import java.util.HashSet
import timber.log.Timber

// TODO: Find better solution instead of excessively using volatile and synchronized.
//  - and use RxJava instead of bad async tasks.
class AppProvider private constructor(private val mContext: Context) {

    /** Represents all applications that are shown in Launcher. */
    private var mLauncherItems: MutableList<LauncherItem>? = null

    /** Represents launcher items stored in database. */
    private var mDatabaseItems: List<LauncherItem>? = null

    /** Represents all applications installed on the device. */
    private var mApplicationItems: Map<String, ApplicationItem> = emptyMap()

    /** Represents all shortcuts which user has created. */
    private var mShortcutInfoCompats: Map<String, ShortcutInfoCompat> = emptyMap()

    private var appsLoaded = false
    private var shortcutsLoaded = false
    private var databaseLoaded = false

    private lateinit var mAppsRepository: AppsRepository
    private val appsRepository: AppsRepository = AppsRepository.getAppsRepository()

    private val pendingPackages = MultiHashMap<UserHandle, String>()

    val context: Context
        get() = mContext

    private var isLoading = false
    private var mStopped = false
    private var isSdCardReady = false

    init {
        isLoading = false
        initialise()
    }

    private fun initialise() {
        val manager = mContext.getSystemService(Context.USER_SERVICE) as UserManager
        val launcher = mContext.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

        launcher.registerCallback(object : LauncherApps.Callback() {
            override fun onPackageRemoved(packageName: String, user: android.os.UserHandle) {
                if (packageName.equals(MICROG_PACKAGE, ignoreCase = true) ||
                    packageName.equals(MUPDF_PACKAGE, ignoreCase = true)
                ) {
                    return
                }

                PackageAddedRemovedHandler.handleEvent(
                    mContext,
                    Intent.ACTION_PACKAGE_REMOVED,
                    packageName,
                    UserHandle(manager.getSerialNumberForUser(user), user),
                    false
                )
            }

            override fun onPackageAdded(packageName: String, user: android.os.UserHandle) {
                if (packageName.equals(MICROG_PACKAGE, ignoreCase = true) ||
                    packageName.equals(MUPDF_PACKAGE, ignoreCase = true)
                ) {
                    return
                }

                PackageAddedRemovedHandler.handleEvent(
                    mContext,
                    Intent.ACTION_PACKAGE_ADDED,
                    packageName,
                    UserHandle(manager.getSerialNumberForUser(user), user),
                    false
                )
            }

            override fun onPackageChanged(packageName: String, user: android.os.UserHandle) {
                if (packageName.equals(MICROG_PACKAGE, ignoreCase = true) ||
                    packageName.equals(MUPDF_PACKAGE, ignoreCase = true)
                ) {
                    return
                }

                PackageAddedRemovedHandler.handleEvent(
                    mContext,
                    Intent.ACTION_PACKAGE_CHANGED,
                    packageName,
                    UserHandle(manager.getSerialNumberForUser(user), user),
                    true
                )
            }

            override fun onPackagesAvailable(
                packageNames: Array<String>,
                user: android.os.UserHandle,
                replacing: Boolean
            ) {
                Timber.tag(TAG).d(
                    "onPackagesAvailable() called with: packageNames = [${Arrays.toString(packageNames)}], user = [$user], replacing = [$replacing]"
                )
                for (packageName in packageNames) {
                    PackageAddedRemovedHandler.handleEvent(
                        mContext,
                        Intent.ACTION_MEDIA_MOUNTED,
                        packageName,
                        UserHandle(manager.getSerialNumberForUser(user), user),
                        false
                    )
                }
            }

            override fun onPackagesUnavailable(
                packageNames: Array<String>,
                user: android.os.UserHandle,
                replacing: Boolean
            ) {
                Timber.tag(TAG).d(
                    "onPackagesUnavailable() called with: packageNames = [${Arrays.toString(packageNames)}], user = [$user], replacing = [$replacing]"
                )
                PackageAddedRemovedHandler.handleEvent(
                    mContext,
                    Intent.ACTION_MEDIA_UNMOUNTED,
                    null,
                    UserHandle(manager.getSerialNumberForUser(user), user),
                    false
                )
            }

            override fun onPackagesSuspended(packageNames: Array<String>, user: android.os.UserHandle) {
                Timber.tag(TAG).d(
                    "onPackagesSuspended() called with: packageNames = [${Arrays.toString(packageNames)}], user = [$user]"
                )
            }

            override fun onPackagesUnsuspended(packageNames: Array<String>, user: android.os.UserHandle) {
                super.onPackagesUnsuspended(packageNames, user)
                Timber.tag(TAG).d(
                    "onPackagesUnsuspended() called with: packageNames = [${Arrays.toString(packageNames)}], user = [$user]"
                )
            }
        })

        mAppsRepository = AppsRepository.getAppsRepository()
    }

    @Synchronized
    fun reload(force: Boolean) {
        Timber.tag(TAG).d("reload() called")

        isSdCardReady = Utilities.isBootCompleted()

        val launcherItems = mLauncherItems
        if (!force && !launcherItems.isNullOrEmpty()) {
            mAppsRepository.updateAppsRelay(launcherItems)
        }

        initializeAppLoading(LoadAppsTask())
        if (Utilities.ATLEAST_OREO) {
            initializeShortcutsLoading(LoadShortcutTask())
        } else {
            shortcutsLoaded = true
        }
        initializeDatabaseLoading(LoadDatabaseTask())
    }

    @Synchronized
    private fun initializeAppLoading(loader: LoadAppsTask) {
        Timber.tag(TAG).d("initializeAppLoading() called with: loader = [$loader]")
        appsLoaded = false
        loader.setAppProvider(this)
        loader.executeOnExecutor(AppExecutors.getInstance().appIO())
    }

    @Synchronized
    private fun initializeShortcutsLoading(loader: LoadShortcutTask) {
        Timber.tag(TAG).d("initializeShortcutsLoading() called with: loader = [$loader]")
        shortcutsLoaded = false
        loader.setAppProvider(this)
        loader.executeOnExecutor(AppExecutors.getInstance().shortcutIO())
    }

    @Synchronized
    private fun initializeDatabaseLoading(loader: LoadDatabaseTask) {
        Timber.tag(TAG).d("initializeDatabaseLoading() called with: loader = [$loader]")
        databaseLoaded = false
        loader.setAppProvider(this)
        loader.executeOnExecutor(AppExecutors.getInstance().diskIO())
    }

    @Synchronized
    fun loadAppsOver(appItemsPair: Map<String, ApplicationItem>) {
        Timber.tag(TAG).d("loadAppsOver() called %s", mStopped)
        mApplicationItems = appItemsPair
        appsLoaded = true
        handleAllProviderLoaded()
    }

    @Synchronized
    fun loadShortcutsOver(shortcuts: Map<String, ShortcutInfoCompat>) {
        Timber.tag(TAG).d("loadShortcutsOver() called with: shortcuts = [$shortcuts]$mStopped")
        mShortcutInfoCompats = shortcuts
        shortcutsLoaded = true
        handleAllProviderLoaded()
    }

    @Synchronized
    fun loadDatabaseOver(databaseItems: List<LauncherItem>) {
        Timber.tag(TAG).d("loadDatabaseOver() called with: databaseItems = [${Thread.currentThread().name}]$mStopped")
        mDatabaseItems = databaseItems
        databaseLoaded = true
        handleAllProviderLoaded()
    }

    @Synchronized
    private fun handleAllProviderLoaded() {
        if (appsLoaded && shortcutsLoaded && databaseLoaded) {
            val databaseItems = mDatabaseItems
            mLauncherItems = if (databaseItems.isNullOrEmpty()) {
                prepareDefaultLauncherItems()
            } else {
                prepareLauncherItems(databaseItems)
            }
            mAppsRepository.updateAppsRelay(mLauncherItems.orEmpty())
        }
    }

    private fun prepareLauncherItems(databaseItems: List<LauncherItem>): MutableList<LauncherItem> {
        Timber.tag(TAG).d("prepareLauncherItems() called")

        val foldersIndex = LongSparseArray<Int>()
        val launcherItems = ArrayList<LauncherItem>()
        val applicationItems = ArrayList(mApplicationItems.values)

        Timber.tag(TAG).i("Total number of apps: %s", applicationItems.size)
        Timber.tag(TAG).i("Total number of items in database: %s", databaseItems.size)
        for (databaseItem in LauncherDatabaseItemOrderPolicy.parentsBeforeFolderChildren(databaseItems)) {
            if (databaseItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
                var applicationItem = mApplicationItems[databaseItem.id]
                if (applicationItem == null) {
                    val userHandle = UserHandle()
                    if ((isAppOnSdcard(databaseItem.packageName, userHandle) || !isSdCardReady) &&
                        !DISABLED_PACKAGES.contains(databaseItem.packageName)
                    ) {
                        Timber.tag(TAG).d("Missing package: %s", databaseItem.packageName)
                        Timber.tag(TAG).d("Is App on Sdcard %s", isAppOnSdcard(databaseItem.packageName, userHandle))
                        Timber.tag(TAG).d("Is Sdcard ready %s", isSdCardReady)

                        val packageName = databaseItem.packageName
                        if (packageName != null) {
                            pendingPackages.addToList(userHandle, packageName)
                        }
                        applicationItem = ApplicationItem().apply {
                            id = databaseItem.id
                            title = databaseItem.title
                            user = userHandle
                            componentName = databaseItem.getTargetComponent()
                            this.packageName = databaseItem.packageName
                            icon = context.getDrawable(R.drawable.default_icon)
                            isDisabled = true
                        }
                    } else {
                        DatabaseManager.getManager(mContext).removeLauncherItem(databaseItem.id)
                        continue
                    }
                }

                applicationItem.container = databaseItem.container
                applicationItem.screenId = databaseItem.screenId
                applicationItem.cell = databaseItem.cell
                applicationItem.keyId = databaseItem.keyId
                if (applicationItem.container == Constants.CONTAINER_DESKTOP.toLong() ||
                    applicationItem.container == Constants.CONTAINER_HOTSEAT.toLong()
                ) {
                    launcherItems.add(applicationItem)
                } else {
                    val index = foldersIndex[applicationItem.container]
                    if (index != null) {
                        val folderItem = launcherItems[index] as FolderItem
                        folderItem.items?.add(applicationItem)
                    } else {
                        Timber.tag(TAG).e("folder not found for item: %s", applicationItem.id)
                    }
                }
            } else if (databaseItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                val shortcutItem = if (Utilities.ATLEAST_OREO) {
                    prepareShortcutForOreo(databaseItem)
                } else {
                    prepareShortcutForNougat(databaseItem)
                }

                if (shortcutItem == null) {
                    DatabaseManager.getManager(mContext).removeLauncherItem(databaseItem.id)
                    continue
                }

                if (shortcutItem.container == Constants.CONTAINER_DESKTOP.toLong() ||
                    shortcutItem.container == Constants.CONTAINER_HOTSEAT.toLong()
                ) {
                    launcherItems.add(shortcutItem)
                } else {
                    val folderItem = launcherItems[foldersIndex[shortcutItem.container]!!] as FolderItem
                    if (folderItem.items == null) {
                        folderItem.items = ArrayList()
                    }
                    folderItem.items?.add(shortcutItem)
                }
            } else if (databaseItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = FolderItem().apply {
                    id = databaseItem.id
                    title = databaseItem.title
                    container = databaseItem.container
                    cell = databaseItem.cell
                    items = ArrayList()
                    screenId = databaseItem.screenId
                }
                foldersIndex.put(folderItem.id.toLong(), launcherItems.size)
                launcherItems.add(folderItem)
            }
        }

        val folderItemsIndex = ArrayList<Int>()
        for (i in 0 until foldersIndex.size()) {
            val itemIndex = foldersIndex[foldersIndex.keyAt(i)]!!
            folderItemsIndex.add(itemIndex)
        }
        Collections.sort(folderItemsIndex)
        for (i in folderItemsIndex.size - 1 downTo 0) {
            val itemIndex = folderItemsIndex[i]
            val folderItem = launcherItems[itemIndex] as FolderItem
            if (folderItem.items.isNullOrEmpty()) {
                DatabaseManager.getManager(mContext).removeLauncherItem(folderItem.id)
                launcherItems.removeAt(itemIndex)
            } else {
                folderItem.icon = GraphicsUtil(mContext).generateFolderIcon(mContext, folderItem)
            }
        }

        applicationItems.removeAll(databaseItems.toSet())
        val mutableList = ArrayList(applicationItems)
        mutableList.sortWith { app1, app2 ->
            Collator.getInstance().compare(app1.title.toString(), app2.title.toString())
        }
        launcherItems.addAll(mutableList)
        return launcherItems
    }

    private fun isAppOnSdcard(packageName: String?, userHandle: UserHandle): Boolean {
        packageName ?: return false
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val info = (mContext.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps)
                    .getApplicationInfo(
                        packageName,
                        PackageManager.MATCH_UNINSTALLED_PACKAGES,
                        userHandle.getRealHandle()
                    )
                info != null && info.flags and ApplicationInfo.FLAG_EXTERNAL_STORAGE != 0
            } else {
                val info = context.packageManager.getApplicationInfo(
                    packageName,
                    PackageManager.MATCH_UNINSTALLED_PACKAGES
                )
                info != null && info.enabled
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            false
        }
    }

    private fun prepareShortcutForNougat(databaseItem: LauncherItem): ShortcutItem {
        val shortcutItem = ShortcutItem()
        shortcutItem.id = databaseItem.id
        shortcutItem.packageName = databaseItem.packageName
        shortcutItem.title = databaseItem.title.toString()
        shortcutItem.icon_blob = databaseItem.icon_blob
        val iconBlob = databaseItem.icon_blob!!
        val bitmap = BitmapFactory.decodeByteArray(iconBlob, 0, iconBlob.size)
        shortcutItem.icon = BitmapDrawable(mContext.resources, bitmap)
        shortcutItem.launchIntent = databaseItem.getIntent()
        shortcutItem.launchIntentUri = databaseItem.launchIntentUri
        shortcutItem.container = databaseItem.container
        shortcutItem.screenId = databaseItem.screenId
        shortcutItem.cell = databaseItem.cell
        shortcutItem.user = UserHandle()
        return shortcutItem
    }

    private fun prepareShortcutForOreo(databaseItem: LauncherItem): ShortcutItem? {
        val info = mShortcutInfoCompats[databaseItem.id]
        if (info == null) {
            Timber.tag(TAG).d("prepareShortcutForOreo() called with: databaseItem = [$databaseItem]")
            return null
        }

        val shortcutItem = ShortcutItem()
        shortcutItem.id = info.id
        shortcutItem.packageName = info.`package`
        shortcutItem.title = info.shortLabel.toString()
        val icon = DeepShortcutManager.getInstance(mContext)
            .getShortcutIconDrawable(info, mContext.resources.displayMetrics.densityDpi)
        shortcutItem.icon = BlissLauncher.getApplication(mContext).iconsHandler.convertIcon(icon)
        shortcutItem.launchIntent = info.makeIntent()
        shortcutItem.container = databaseItem.container
        shortcutItem.screenId = databaseItem.screenId
        shortcutItem.cell = databaseItem.cell
        shortcutItem.user = UserHandle()
        return shortcutItem
    }

    private fun prepareDefaultLauncherItems(): MutableList<LauncherItem> {
        val launcherItems = ArrayList<LauncherItem>()
        val pinnedItems = ArrayList<LauncherItem>()
        val pm = mContext.packageManager
        val intents = arrayOf(
            Intent(Intent.ACTION_DIAL),
            Intent(Intent.ACTION_VIEW, Uri.parse("sms:")),
            Intent(Intent.ACTION_VIEW, Uri.parse("http:")),
            Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        )
        for (i in intents.indices) {
            val packageName = AppUtils.getPackageNameForIntent(intents[i], pm)
            val launcherApps = mContext.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
            val list: List<LauncherActivityInfo> = launcherApps.getActivityList(packageName, Process.myUserHandle())
            for (launcherActivityInfo in list) {
                val applicationItem = mApplicationItems[launcherActivityInfo.componentName.flattenToString()]
                if (applicationItem != null) {
                    applicationItem.container = Constants.CONTAINER_HOTSEAT.toLong()
                    applicationItem.cell = i
                    pinnedItems.add(applicationItem)
                    break
                }
            }
        }

        val desktopItems = ArrayList<ApplicationItem>()
        for ((_, applicationItem) in mApplicationItems) {
            if (!pinnedItems.contains(applicationItem)) {
                desktopItems.add(applicationItem)
            }
        }

        val arrangedDesktopItems = DefaultLauncherHomeLayoutPolicy.arrangeDesktopItems(
            apps = desktopItems,
            launcherPackageName = mContext.packageName,
            maxAppsPerPage = LauncherHomeLayoutPreferences.read(mContext).maxAppsPerPage
        )
        arrangedDesktopItems.filterIsInstance<FolderItem>().forEach { folderItem ->
            folderItem.icon = GraphicsUtil(mContext).generateFolderIcon(mContext, folderItem)
        }

        launcherItems.addAll(arrangedDesktopItems)
        launcherItems.addAll(pinnedItems)
        return launcherItems
    }

    fun getAppsRepository(): AppsRepository = appsRepository

    fun clear() {
        sInstance = null
        mLauncherItems = ArrayList()
        mAppsRepository.updateAppsRelay(Collections.emptyList())
    }

    @Synchronized
    fun isRunning(): Boolean = !mStopped

    companion object {
        private const val MICROG_PACKAGE = "com.google.android.gms"
        private const val MUPDF_PACKAGE = "com.artifex.mupdf.mini.app"
        private const val PDF_VIEWER_PACKAGE = "foundation.e.pdfviewer"
        private const val OPENKEYCHAIN_PACKAGE = "org.sufficientlysecure.keychain"
        private const val LIBREOFFICE_PACKAGE = "org.documentfoundation.libreoffice"
        private const val LIBREOFFICE_PACKAGE2 = "org.example.libreoffice"
        private const val SIM_TOOLKIT = "com.android.stk"
        private const val TAG = "AppProvider"

        @JvmField
        val DISABLED_PACKAGES: HashSet<String> = hashSetOf(
            MICROG_PACKAGE,
            MUPDF_PACKAGE,
            PDF_VIEWER_PACKAGE,
            OPENKEYCHAIN_PACKAGE,
            LIBREOFFICE_PACKAGE,
            LIBREOFFICE_PACKAGE2,
            SIM_TOOLKIT
        )

        @Volatile
        private var sInstance: AppProvider? = null

        @JvmStatic
        fun getInstance(context: Context): AppProvider {
            if (sInstance == null) {
                synchronized(AppProvider::class.java) {
                    if (sInstance == null) {
                        sInstance = AppProvider(context)
                        sInstance!!.reload(true)
                    }
                }
            }
            return sInstance!!
        }
    }
}
