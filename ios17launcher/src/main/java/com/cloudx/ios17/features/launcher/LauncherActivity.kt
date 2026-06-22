package com.cloudx.ios17.features.launcher

import android.Manifest
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.WallpaperManager
import android.app.usage.UsageStats
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.ContentResolver
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ActivityInfo.CONFIG_ORIENTATION
import android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.StrictMode
import android.os.UserManager
import android.provider.Settings
import android.service.notification.NotificationListenerService
import android.view.ContextThemeWrapper
import android.view.DragEvent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Alarm
import com.cloudx.ios17.core.DeviceProfile
import com.cloudx.ios17.core.Preferences
import com.cloudx.ios17.core.Utilities
import com.cloudx.ios17.core.blur.BlurWallpaperProvider
import com.cloudx.ios17.core.broadcast.ManagedProfileBroadcastReceiver
import com.cloudx.ios17.core.broadcast.TimeChangeBroadcastReceiver
import com.cloudx.ios17.core.broadcast.WallpaperChangeReceiver
import com.cloudx.ios17.core.customviews.BlissDragShadowBuilder
import com.cloudx.ios17.core.customviews.BlissFrameLayout
import com.cloudx.ios17.core.customviews.BlissInput
import com.cloudx.ios17.core.customviews.DockGridLayout
import com.cloudx.ios17.core.customviews.HorizontalPager
import com.cloudx.ios17.core.customviews.InsettableFrameLayout
import com.cloudx.ios17.core.customviews.InsettableRelativeLayout
import com.cloudx.ios17.core.customviews.PageIndicatorLinearLayout
import com.cloudx.ios17.core.customviews.RoundedWidgetView
import com.cloudx.ios17.core.customviews.SquareFrameLayout
import com.cloudx.ios17.core.customviews.SquareImageView
import com.cloudx.ios17.core.customviews.WidgetHost
import com.cloudx.ios17.core.database.DatabaseManager
import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.CalendarIcon
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.database.model.ShortcutItem
import com.cloudx.ios17.core.database.model.WidgetItem
import com.cloudx.ios17.core.events.AppAddEvent
import com.cloudx.ios17.core.events.AppChangeEvent
import com.cloudx.ios17.core.events.AppRemoveEvent
import com.cloudx.ios17.core.events.EventRelay
import com.cloudx.ios17.core.events.ShortcutAddEvent
import com.cloudx.ios17.core.executors.AppExecutors
import com.cloudx.ios17.core.utils.AppUtils
import com.cloudx.ios17.core.utils.Constants
import com.cloudx.ios17.core.utils.DepthManager
import com.cloudx.ios17.core.utils.GraphicsUtil
import com.cloudx.ios17.core.utils.UserHandle
import com.cloudx.ios17.core.utils.getActivityThemeRes
import com.cloudx.ios17.core.utils.isWorkspaceDarkText
import com.cloudx.ios17.core.wallpaper.WallpaperManagerCompat
import com.cloudx.ios17.features.launcher.workspace.LauncherPageIndicatorWheelView
import com.cloudx.ios17.features.launcher.workspace.LauncherPageIndicatorWindowPolicy
import com.cloudx.ios17.features.notification.NotificationRepository
import com.cloudx.ios17.features.notification.NotificationService
import com.cloudx.ios17.features.shortcuts.DeepShortcutManager
import com.cloudx.ios17.features.shortcuts.ShortcutKey
import com.cloudx.ios17.features.suggestions.AutoCompleteAdapter
import com.cloudx.ios17.features.suggestions.SearchSuggestionUtil
import com.cloudx.ios17.features.suggestions.SuggestionProvider
import com.cloudx.ios17.features.suggestions.SuggestionsResult
import com.cloudx.ios17.features.usagestats.AppUsageStats
import com.cloudx.ios17.features.weather.DeviceStatusService
import com.cloudx.ios17.features.weather.WeatherPreferences
import com.cloudx.ios17.features.weather.WeatherSourceListenerService
import com.cloudx.ios17.features.weather.WeatherUpdateService
import com.cloudx.ios17.features.weather.WeatherUtils
import com.cloudx.ios17.features.widgets.DefaultWidgets
import com.cloudx.ios17.features.widgets.WidgetManager
import com.cloudx.ios17.features.widgets.WidgetViewBuilder
import com.cloudx.ios17.features.widgets.WidgetsActivity
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.hypot
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt
import me.relex.circleindicator.CircleIndicator
import timber.log.Timber

class LauncherActivity : AppCompatActivity(),
    AutoCompleteAdapter.OnSuggestionClickListener,
    OnSwipeDownListener,
    WallpaperManagerCompat.OnColorsChangedListener {

    private enum class IndicatorMode {
        DOTS,
        SEARCH
    }

    companion object {
        private const val WIDGET_PAGE = 0
        const val REORDER_TIMEOUT = 350
        private const val EMPTY_LOCATION_DRAG = -999
        private const val REQUEST_PERMISSION_CALL_PHONE = 14
        private const val REQUEST_LOCATION_SOURCE_SETTING = 267
        private const val STORAGE_PERMISSION_REQUEST_CODE = 586
        private const val PAGE_INDICATOR_VISIBLE_MS = 2000L
        private const val PAGE_INDICATOR_SEARCH_WIDTH_DP = 104
        private const val PAGE_INDICATOR_SEARCH_HEIGHT_DP = 34
        private const val PAGE_INDICATOR_DOT_PADDING_DP = 4
        const val ACTION_LAUNCHER_RESUME = "com.cloudx.ios17.LauncherActivity.LAUNCHER_RESUME"
        const val EXTRA_FRAGMENT_ARG_KEY = ":settings:fragment_args_key"
        const val EXTRA_SHOW_FRAGMENT_ARGS = ":settings:show_fragment_args"
        const val NOTIFICATION_SETTING = "enabled_notification_listeners"

        @JvmField
        var longPressed = false

        @JvmStatic
        fun getLauncher(context: Context): LauncherActivity {
            if (context is LauncherActivity) {
                return context
            }
            return (context as ContextWrapper).baseContext as LauncherActivity
        }
    }

    private lateinit var contentResolverRef: ContentResolver
    private var permissionString: String? = null
    private var unlockReceiver: BroadcastReceiver? = null
    private lateinit var notificationComponentName: ComponentName

    private val mReorderAlarm = Alarm()
    private val mDockReorderAlarm = Alarm()
    private lateinit var mHorizontalPager: HorizontalPager
    private lateinit var mDock: DockGridLayout
    private lateinit var mIndicator: PageIndicatorLinearLayout
    private var mBottomControlSlot: View? = null
    private var mSearchPill: View? = null
    private val indicatorHandler = Handler(Looper.getMainLooper())
    private val hideIndicatorRunnable = Runnable { hidePageIndicator() }
    private var indicatorMode = IndicatorMode.SEARCH
    private var indicatorWheelView: LauncherPageIndicatorWheelView? = null
    private lateinit var mFolderWindowContainer: ViewGroup
    private lateinit var mFolderAppsViewPager: ViewPager
    private lateinit var mFolderTitleInput: BlissInput
    private var mSearchInput: BlissInput? = null
    private lateinit var mProgressBar: View
    private var currentPageNumber = 0
    private var maxDistanceForFolderCreation = 0f
    private var pages: MutableList<GridLayout> = ArrayList()
    private var dragDropEnabled = true
    private var movingApp: BlissFrameLayout? = null
    private var collidingApp: BlissFrameLayout? = null
    private var folderInterest = false
    private lateinit var wobbleAnimation: Animation
    private lateinit var wobbleReverseAnimation: Animation
    private var scrollCorner = 0
    private var parentPage = -99
    private var folderFromDock = false
    private var isWobbling = false
    private var mCompositeDisposable: CompositeDisposable? = null
    private var mWobblingCountDownTimer: CountDownTimer? = null
    private val mCalendarIcons: MutableList<BlissFrameLayout> = ArrayList()
    private var timeChangedReceiver: TimeChangeBroadcastReceiver? = null
    private var isUiDone = false
    private var mAppsWithNotifications: Set<String> = HashSet()

    private lateinit var mLauncherView: View
    private lateinit var mDeviceProfile: DeviceProfile
    private var mLongClickStartsDrag = true
    private var isDragging = false
    private var dragShadowBuilder: BlissDragShadowBuilder? = null
    private var allAppsDisplayed = false
    private var forceRefreshSuggestedApps = false

    private var mSuggestedApps: List<ApplicationItem> = ArrayList()
    private lateinit var swipeSearchContainer: FrameLayout
    private lateinit var workspace: InsettableRelativeLayout
    private lateinit var blurLayer: View

    private var activeFolder: FolderItem? = null
    private var activeFolderView: BlissFrameLayout? = null

    private lateinit var mAppWidgetManager: AppWidgetManager
    private lateinit var mAppWidgetHost: WidgetHost
    private lateinit var widgetContainer: LinearLayout

    private var widgetsPage: FrameLayout? = null
    private var appLibraryPage: FrameLayout? = null
    private lateinit var contextOverlay: View
    private var launcherOptionsPopup: PopupWindow? = null
    private var currentLauncherItems: MutableList<LauncherItem> = ArrayList()
    private var searchDisposableObserver: SearchInputDisposableObserver? = null
    private var currentAnimator: AnimatorSet? = null
    private lateinit var startBounds: Rect
    private lateinit var finalBounds: Rect
    private var startScaleFinal = 0f
    private var showSwipeSearch = false
    private var activeRoundedWidgetView: RoundedWidgetView? = null

    private var events: EventRelay? = null
    private var managedProfileReceiver: ManagedProfileBroadcastReceiver? = null

    private var moveTo = 0
    private lateinit var oldConfig: Configuration
    private lateinit var wallpaperChangeReceiver: WallpaperChangeReceiver
    private var mDetector: GestureDetectorCompat? = null
    private var enableLocationDialog: AlertDialog? = null

    private var mDepthManager: DepthManager? = null

    private var mThemeRes = R.style.HomeScreenTheme
    private lateinit var mLightLayoutInflater: LayoutInflater

    private lateinit var mInsetsController: WindowInsetsControllerCompat

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareBroadcastReceivers()

        WallpaperManagerCompat.getInstance(this).addOnChangeListener(this)
        val themeRes = getActivityThemeRes(this)
        if (themeRes != mThemeRes) {
            mThemeRes = themeRes
            setTheme(themeRes)
        }

        contentResolverRef = contentResolver
        permissionString = Settings.Secure.getString(contentResolverRef, NOTIFICATION_SETTING)
        notificationComponentName = ComponentName(this, NotificationService::class.java)

        unlockReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val action = intent.action
                if (Intent.ACTION_USER_PRESENT.equals(action, ignoreCase = true) &&
                    Preferences.shouldShowNotificationDialog(context)
                ) {
                    if (permissionString == null || !permissionString!!.contains(packageName)) {
                        showNotifPermissionDeniedDialog()
                    }
                }
            }
        }

        oldConfig = Configuration(resources.configuration)
        BlissLauncher.getApplication(this).resetDeviceProfile()
        mDeviceProfile = BlissLauncher.getApplication(this).deviceProfile

        mAppWidgetManager = BlissLauncher.getApplication(this).appWidgetManager
        mAppWidgetHost = BlissLauncher.getApplication(this).appWidgetHost

        mLauncherView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
        setContentView(mLauncherView)
        setupViews()

        val wm = getSystemService(WALLPAPER_SERVICE) as WallpaperManager
        wm.suggestDesiredDimensions(mDeviceProfile.widthPx, mDeviceProfile.heightPx)

        mProgressBar.visibility = VISIBLE

        registerUnlockBroadcastReceiver()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), STORAGE_PERMISSION_REQUEST_CODE)
        }

        NotificationListenerService.requestRebind(ComponentName(this, NotificationService::class.java))

        createOrUpdateIconGrid()
        addDefaultWidgets()

        if (Utilities.ATLEAST_R) {
            mDepthManager = DepthManager(this)
        }

        if (isWorkspaceDarkText(this)) {
            var flags = mLauncherView.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            mLauncherView.systemUiVisibility = flags
        }
        val lightContext = ContextThemeWrapper(this, R.style.HomeScreenTheme)
        mLightLayoutInflater = layoutInflater.cloneInContext(lightContext)

        mInsetsController = WindowInsetsControllerCompat(window, mLauncherView)
    }

    fun registerUnlockBroadcastReceiver() {
        val unlockFilter = IntentFilter()
        unlockFilter.addAction(Intent.ACTION_USER_PRESENT)
        registerReceiver(unlockReceiver, unlockFilter)
    }

    fun getRootView(): View = mLauncherView

    private fun setupViews() {
        workspace = mLauncherView.findViewById(R.id.workspace)
        wallpaperChangeReceiver = WallpaperChangeReceiver(workspace)
        workspace.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                wallpaperChangeReceiver.setWindowToken(v.windowToken)
            }

            override fun onViewDetachedFromWindow(v: View) {
                wallpaperChangeReceiver.setWindowToken(null)
            }
        })
        mHorizontalPager = mLauncherView.findViewById(R.id.pages_container)
        blurLayer = mLauncherView.findViewById(R.id.blur_layer)
        blurLayer.alpha = 0f

        mDock = mLauncherView.findViewById(R.id.dock)
        mDock.columnCount = mDeviceProfile.numHotseatIcons
        mDock.rowCount = 1
        mIndicator = mLauncherView.findViewById(R.id.page_indicator)
        mBottomControlSlot = mLauncherView.findViewById(R.id.bottom_control_slot)
        mSearchPill = mLauncherView.findViewById(R.id.search_pill)
        mSearchPill?.visibility = GONE
        mIndicator.setOnClickListener {
            if (indicatorMode == IndicatorMode.SEARCH && swipeSearchContainer.visibility != VISIBLE) {
                showSwipeSearchContainer()
            }
        }
        contextOverlay = mLauncherView.findViewById(R.id.context_overlay)
        contextOverlay.setOnClickListener { dismissLauncherOptionsPopup() }
        mFolderWindowContainer = mLauncherView.findViewById(R.id.folder_window_container)
        mFolderAppsViewPager = mLauncherView.findViewById(R.id.folder_apps)
        mFolderTitleInput = mLauncherView.findViewById(R.id.folder_title)
        mProgressBar = mLauncherView.findViewById(R.id.progressbar)
        swipeSearchContainer = mLauncherView.findViewById(R.id.swipe_search_container)
        maxDistanceForFolderCreation = (0.45f * mDeviceProfile.iconSizePx).toInt().toFloat()

        scrollCorner = mDeviceProfile.iconDrawablePaddingPx / 2

        wobbleAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble)
        wobbleReverseAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble_reverse)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        workspace.setOnClickListener {
            if (swipeSearchContainer.visibility == VISIBLE) {
                hideSwipeSearchContainer()
            }
        }
        workspace.setOnLongClickListener { v ->
            if (!isWobbling &&
                swipeSearchContainer.visibility != VISIBLE &&
                mFolderWindowContainer.visibility != VISIBLE
            ) {
                showWorkspaceOptions(v)
                true
            } else {
                false
            }
        }
    }

    private fun createOrUpdateIconGrid() {
        compositeDisposableBag.add(
            BlissLauncher.getApplication(this).appProvider.getAppsRepository()
                .getAppsRelay()
                .distinctUntilChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<LauncherItem>>() {
                    override fun onNext(launcherItems: List<LauncherItem>) {
                        if (launcherItems.isEmpty()) {
                            BlissLauncher.getApplication(this@LauncherActivity).appProvider.reload(true)
                        } else if (!allAppsDisplayed) {
                            showApps(launcherItems)
                        }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onComplete() = Unit
                })
        )
    }

    private fun addDefaultWidgets() {
        val widgetIds = mAppWidgetHost.appWidgetIds
        val existingProviders = HashSet<ComponentName>()
        for (widgetId in widgetIds) {
            val info = mAppWidgetManager.getAppWidgetInfo(widgetId) ?: continue
            existingProviders.add(info.provider)
        }

        if (!Preferences.getAddedEcloudWidget(this)) {
            val provider = DefaultWidgets.ecloudWidget
            if (existingProviders.contains(provider) || allocateAndBindWidget(provider)) {
                Preferences.setAddedEcloudWidget(this)
            }
        }

        if (!Preferences.getAddedPrivacyWidget(this)) {
            val provider = DefaultWidgets.privacyWidget
            if (existingProviders.contains(provider) || allocateAndBindWidget(provider)) {
                Preferences.setAddedPrivacyWidget(this)
            }
        }

        if (!Preferences.getAddedWeatherWidget(this)) {
            val provider = DefaultWidgets.weatherWidget
            if (existingProviders.contains(provider) || allocateAndBindWidget(provider)) {
                Preferences.setAddedWeatherWidget(this)
            }
        }
    }

    private fun allocateAndBindWidget(provider: ComponentName): Boolean {
        val appWidgetId = mAppWidgetHost.allocateAppWidgetId()
        if (!mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, provider)) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            return false
        }
        val widgetItem = WidgetItem(appWidgetId)
        widgetItem.order = 0
        DatabaseManager.getManager(this).insertWidget(widgetItem)
        return true
    }

    private fun prepareBroadcastReceivers() {
        timeChangedReceiver = TimeChangeBroadcastReceiver.register(this)
        managedProfileReceiver = ManagedProfileBroadcastReceiver.register(this)
    }

    private val compositeDisposableBag: CompositeDisposable
        get() {
            if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
                mCompositeDisposable = CompositeDisposable()
            }
            return mCompositeDisposable!!
        }

    fun getCompositeDisposable(): CompositeDisposable = compositeDisposableBag

    fun updateAllCalendarIcons(calendar: Calendar) {
        for (blissIcon in mCalendarIcons) {
            val calendarIcon = CalendarIcon(
                blissIcon.findViewById(R.id.calendar_month_textview),
                blissIcon.findViewById(R.id.calendar_date_textview)
            )
            updateCalendarIcon(calendarIcon, calendar)
        }
    }

    private fun updateCalendarIcon(calendarIcon: CalendarIcon, calendar: Calendar) {
        calendarIcon.monthTextView.text = Utilities.convertMonthToString()
        calendarIcon.dayTextView.text = calendar.get(Calendar.DAY_OF_MONTH).toString()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        if (!Preferences.shouldAskForNotificationAccess(this)) {
            if (Preferences.shouldShowNotificationDialog(this)) {
                showNotifPermissionDeniedDialog()
                unlockReceiver?.let {
                    unregisterReceiver(it)
                    unlockReceiver = null
                }
            }

            permissionString = if (permissionString == null) {
                ""
            } else {
                "$permissionString:"
            }

            permissionString += notificationComponentName.flattenToString()
        }

        mDepthManager?.updateDepth()

        widgetsPage?.let {
            refreshSuggestedApps(it, forceRefreshSuggestedApps)
        }

        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(ACTION_LAUNCHER_RESUME))

        if (::widgetContainer.isInitialized) {
            val widgetManager = WidgetManager.getInstance()
            var id = widgetManager.dequeRemoveId()
            while (id != null) {
                for (i in 0 until widgetContainer.childCount) {
                    val child = widgetContainer.getChildAt(i)
                    if (child is RoundedWidgetView && child.appWidgetId == id) {
                        widgetContainer.removeViewAt(i)
                        DatabaseManager.getManager(this).removeWidget(id)
                        break
                    }
                }
                id = widgetManager.dequeRemoveId()
            }

            var widgetView = widgetManager.dequeAddWidgetView()
            while (widgetView != null) {
                val queuedWidgetView = widgetView ?: break
                val createdWidgetView = WidgetViewBuilder.create(this, queuedWidgetView)
                if (createdWidgetView != null) {
                    addWidgetToContainer(createdWidgetView)
                    DatabaseManager.getManager(this).insertWidget(WidgetItem(createdWidgetView.appWidgetId))
                }
                widgetView = widgetManager.dequeAddWidgetView()
            }
        }
    }

    private fun addWidgetToContainer(widgetView: RoundedWidgetView) {
        widgetContainer.addView(widgetView)
    }

    override fun onPause() {
        super.onPause()
        if (widgetsPage != null) {
            hideWidgetResizeContainer()
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        timeChangedReceiver?.let { TimeChangeBroadcastReceiver.unregister(this, it) }
        managedProfileReceiver?.let { ManagedProfileBroadcastReceiver.unregister(this, it) }
        compositeDisposableBag.dispose()
        events?.unsubscribe()
        if (enableLocationDialog?.isShowing == true) {
            enableLocationDialog?.dismiss()
        }
        BlissLauncher.getApplication(this).appProvider.clear()
        WallpaperManagerCompat.getInstance(this).removeOnChangeListener(this)
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        val diff = newConfig.diff(oldConfig)
        if ((diff and (CONFIG_ORIENTATION or CONFIG_SCREEN_SIZE)) != 0) {
            recreate()
        }
        oldConfig.setTo(newConfig)
        super.onConfigurationChanged(newConfig)
    }

    fun onAppAddEvent(appAddEvent: AppAddEvent) {
        updateOrAddApp(appAddEvent.packageName, appAddEvent.userHandle)
        if (moveTo != -1) {
            mHorizontalPager.setCurrentPage(moveTo)
            moveTo = -1
        }
    }

    fun onAppRemoveEvent(appRemoveEvent: AppRemoveEvent) {
        forceRefreshSuggestedApps = true
        removePackageFromLauncher(appRemoveEvent.packageName, appRemoveEvent.userHandle)
        DatabaseManager.getManager(this).saveLayouts(pages, mDock)
        rebindAllWidgets()
    }

    fun onAppChangeEvent(appChangeEvent: AppChangeEvent) {
        updateOrAddApp(appChangeEvent.packageName, appChangeEvent.userHandle)
        DatabaseManager.getManager(this).saveLayouts(pages, mDock)
    }

    fun onShortcutAddEvent(shortcutAddEvent: ShortcutAddEvent) {
        moveTo = -1
        updateOrAddShortcut(shortcutAddEvent.shortcutItem)
        DatabaseManager.getManager(this).saveLayouts(pages, mDock)
        Toast.makeText(this, getString(R.string.toast_shortcut_added), Toast.LENGTH_SHORT).show()
        if (moveTo != -1) {
            mHorizontalPager.setCurrentPage(moveTo)
            moveTo = -1
        }
    }

    private fun addLauncherItem(launcherItem: LauncherItem?) {
        if (pages.isEmpty() || launcherItem == null) {
            return
        }

        val view = prepareLauncherItem(launcherItem)

        var current = 0
        while (current < pages.size && pages[current].childCount == mDeviceProfile.maxAppsPerPage) {
            current++
        }

        if (current == pages.size) {
            pages.add(preparePage())
            mHorizontalPager.addView(pages[current])
            refreshPageIndicator()
        }
        launcherItem.screenId = current.toLong()
        launcherItem.cell = pages[current].childCount - 1
        launcherItem.container = Constants.CONTAINER_DESKTOP.toLong()
        addAppToGrid(pages[current], view)
        moveTo = current + 1
    }

    private fun updateOrAddShortcut(shortcutItem: ShortcutItem) {
        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                val gridLayout = mFolderAppsViewPager.getChildAt(i) as GridLayout
                for (j in 0 until gridLayout.childCount) {
                    val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                    val existingItem = getAppDetails(viewGroup)
                    if (existingItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                        val existingShortcutItem = existingItem as ShortcutItem
                        if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                            val blissFrameLayout = prepareLauncherItem(shortcutItem)
                            val iconLayoutParams = GridLayout.LayoutParams()
                            iconLayoutParams.height = mDeviceProfile.cellHeightPx
                            iconLayoutParams.width = mDeviceProfile.cellWidthPx
                            gridLayout.removeViewAt(j)
                            gridLayout.addView(blissFrameLayout, j, iconLayoutParams)
                            return
                        }
                    }
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val viewGroup = mDock.getChildAt(i) as BlissFrameLayout
            val launcherItem = getAppDetails(viewGroup)
            if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = launcherItem as FolderItem
                val items = folderItem.items!!
                for (k in items.indices) {
                    if (items[k].itemType == Constants.ITEM_TYPE_SHORTCUT) {
                        val existingShortcutItem = items[k] as ShortcutItem
                        if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                            items[k] = shortcutItem
                            folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                            val blissFrameLayout = prepareLauncherItem(launcherItem)
                            mDock.removeViewAt(i)
                            addAppToDock(blissFrameLayout, i)
                            return
                        }
                    }
                }
            } else if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                val existingShortcutItem = launcherItem as ShortcutItem
                if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                    val blissFrameLayout = prepareLauncherItem(shortcutItem)
                    mDock.removeViewAt(i)
                    addAppToDock(blissFrameLayout, i)
                    return
                }
            }
        }

        for (i in pages.indices) {
            val gridLayout = pages[i]
            for (j in 0 until gridLayout.childCount) {
                val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                val launcherItem = getAppDetails(viewGroup)
                if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                    val folderItem = launcherItem as FolderItem
                    val items = folderItem.items!!
                    for (k in items.indices) {
                        if (items[k].itemType == Constants.ITEM_TYPE_SHORTCUT) {
                            val existingShortcutItem = items[k] as ShortcutItem
                            if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                                items[k] = shortcutItem
                                folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                                val blissFrameLayout = prepareLauncherItem(launcherItem)
                                gridLayout.removeViewAt(j)
                                addAppToGrid(gridLayout, blissFrameLayout, j)
                                moveTo = i + 1
                                return
                            }
                        }
                    }
                } else if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                    val existingShortcutItem = launcherItem as ShortcutItem
                    if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                        val blissFrameLayout = prepareLauncherItem(shortcutItem)
                        gridLayout.removeViewAt(j)
                        addAppToGrid(gridLayout, blissFrameLayout, j)
                        moveTo = i + 1
                        return
                    }
                }
            }
        }

        addLauncherItem(shortcutItem)
    }

    private fun removePackageFromLauncher(packageName: String, userHandle: UserHandle) {
        handleWobbling(false)
        if (mFolderWindowContainer.visibility == VISIBLE) {
            activeFolder?.items?.let {
                if (removePackageItems(it, packageName, userHandle)) {
                    updateFolder()
                }
            }
        }

        var j = 0
        while (j < mDock.childCount) {
            val appItem = getAppDetails(mDock.getChildAt(j))
            when (appItem.itemType) {
                Constants.ITEM_TYPE_FOLDER -> {
                    val folderItem = appItem as FolderItem
                    removePackageItems(folderItem.items!!, packageName, userHandle)
                    updateFolderInGrid(mDock, folderItem, j)
                    j++
                }
                Constants.ITEM_TYPE_APPLICATION, Constants.ITEM_TYPE_SHORTCUT -> {
                    if (shouldRemoveForPackage(appItem, packageName, userHandle)) {
                        mDock.removeViewAt(j)
                    } else {
                        j++
                    }
                }
                else -> j++
            }
        }

        var i = 0
        while (i < pages.size) {
            val grid = getGridFromPage(pages[i])
            var childIndex = 0
            while (childIndex < grid.childCount) {
                val launcherItem = getAppDetails(grid.getChildAt(childIndex))
                when (launcherItem.itemType) {
                    Constants.ITEM_TYPE_FOLDER -> {
                        val folderItem = launcherItem as FolderItem
                        removePackageItems(folderItem.items!!, packageName, userHandle)
                        updateFolderInGrid(grid, folderItem, childIndex)
                        childIndex++
                    }
                    Constants.ITEM_TYPE_APPLICATION, Constants.ITEM_TYPE_SHORTCUT -> {
                        if (shouldRemoveForPackage(launcherItem, packageName, userHandle)) {
                            grid.removeViewAt(childIndex)
                            if (removeEmptyPage(i, grid)) {
                                i--
                                break
                            }
                        } else {
                            childIndex++
                        }
                    }
                    else -> childIndex++
                }
            }
            i++
        }
    }

    private fun shouldRemoveForPackage(item: LauncherItem, packageName: String, userHandle: UserHandle): Boolean {
        return when (item.itemType) {
            Constants.ITEM_TYPE_APPLICATION -> {
                val app = item as ApplicationItem
                app.packageName.equals(packageName, ignoreCase = true) && app.user!!.isSameUser(userHandle)
            }
            Constants.ITEM_TYPE_SHORTCUT -> {
                val shortcutItem = item as ShortcutItem
                shortcutItem.packageName.equals(packageName, ignoreCase = true)
            }
            else -> false
        }
    }

    private fun removePackageItems(
        items: MutableList<LauncherItem>,
        packageName: String,
        userHandle: UserHandle
    ): Boolean = items.removeAll { shouldRemoveForPackage(it, packageName, userHandle) }

    private fun removeEmptyPage(pageIndex: Int, grid: GridLayout): Boolean {
        if (grid.childCount != 0) {
            return false
        }
        pages.removeAt(pageIndex)
        mHorizontalPager.removeViewAt(pageIndex + 1)
        if (pageIndex == pages.size) {
            mHorizontalPager.scrollLeft(100)
        }
        refreshPageIndicator()
        return true
    }

    private fun updateFolder() {
        mFolderAppsViewPager.adapter?.notifyDataSetChanged()
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        val items = folder.items!!
        when (items.size) {
            0 -> {
                (folderView.parent as? ViewGroup)?.removeView(folderView)
                hideFolderWindowContainer()
            }
            1 -> {
                val item = items[0]
                items.remove(item)
                mFolderAppsViewPager.adapter?.notifyDataSetChanged()
                val view = prepareLauncherItem(item)

                if (folderFromDock) {
                    addAppToDock(view, mDock.indexOfChild(folderView))
                } else {
                    val gridLayout = pages[getCurrentAppsPageNumber()]
                    addAppToGrid(gridLayout, view, gridLayout.indexOfChild(folderView))
                }

                (folderView.parent as? ViewGroup)?.removeView(folderView)
                hideFolderWindowContainer()
            }
            else -> {
                updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                hideFolderWindowContainer()
            }
        }
    }

    private fun updateFolderInGrid(grid: GridLayout, folderItem: FolderItem, folderIndex: Int) {
        if (folderItem.items!!.isEmpty()) {
            grid.removeViewAt(folderIndex)
        } else {
            folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
            val blissFrameLayout = prepareLauncherItem(folderItem)
            grid.removeViewAt(folderIndex)
            if (grid is DockGridLayout) {
                addAppToDock(blissFrameLayout, folderIndex)
            } else {
                addAppToGrid(grid, blissFrameLayout, folderIndex)
            }
        }
    }

    private fun updateOrAddApp(packageName: String, userHandle: UserHandle) {
        handleWobbling(false)
        val updatedAppItem = AppUtils.createAppItem(this, packageName, userHandle)
        if (updatedAppItem == null) {
            removePackageFromLauncher(packageName, userHandle)
            return
        }

        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                val gridLayout = mFolderAppsViewPager.getChildAt(i) as GridLayout
                for (j in 0 until gridLayout.childCount) {
                    val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                    val existingItem = getAppDetails(viewGroup)
                    if (existingItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
                        val existingAppItem = existingItem as ApplicationItem
                        if (existingAppItem.packageName.equals(packageName, ignoreCase = true) &&
                            existingAppItem.user!!.isSameUser(userHandle)
                        ) {
                            val blissFrameLayout = prepareLauncherItem(updatedAppItem)
                            val iconLayoutParams = GridLayout.LayoutParams()
                            iconLayoutParams.height = mDeviceProfile.cellHeightPx
                            iconLayoutParams.width = mDeviceProfile.cellWidthPx
                            gridLayout.removeViewAt(j)
                            gridLayout.addView(blissFrameLayout, j, iconLayoutParams)
                            return
                        }
                    }
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val viewGroup = mDock.getChildAt(i) as BlissFrameLayout
            val existingAppItem = getAppDetails(viewGroup)
            if (existingAppItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = existingAppItem as FolderItem
                val items = folderItem.items!!
                for (k in items.indices) {
                    if (items[k].itemType == Constants.ITEM_TYPE_APPLICATION) {
                        val applicationItem = items[k] as ApplicationItem
                        if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                            applicationItem.user!!.isSameUser(userHandle)
                        ) {
                            items[k] = updatedAppItem
                            folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                            val blissFrameLayout = prepareLauncherItem(existingAppItem)
                            mDock.removeViewAt(i)
                            addAppToDock(blissFrameLayout, i)
                            return
                        }
                    }
                }
            } else if (existingAppItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
                val applicationItem = existingAppItem as ApplicationItem
                if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                    applicationItem.user!!.isSameUser(userHandle)
                ) {
                    val blissFrameLayout = prepareLauncherItem(updatedAppItem)
                    mDock.removeViewAt(i)
                    addAppToDock(blissFrameLayout, i)
                    return
                }
            }
        }

        for (i in pages.indices) {
            val gridLayout = pages[i]
            for (j in 0 until gridLayout.childCount) {
                val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                val existingAppItem = getAppDetails(viewGroup)
                if (existingAppItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                    val folderItem = existingAppItem as FolderItem
                    val items = folderItem.items!!
                    for (k in items.indices) {
                        if (items[k].itemType == Constants.ITEM_TYPE_APPLICATION) {
                            val applicationItem = items[k] as ApplicationItem
                            if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                                applicationItem.user!!.isSameUser(userHandle)
                            ) {
                                items[k] = updatedAppItem
                                folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                                val blissFrameLayout = prepareLauncherItem(existingAppItem)
                                gridLayout.removeViewAt(j)
                                addAppToGrid(gridLayout, blissFrameLayout, j)
                                moveTo = i + 1
                                return
                            }
                        }
                    }
                } else if (existingAppItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
                    val applicationItem = existingAppItem as ApplicationItem
                    if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                        applicationItem.user!!.isSameUser(userHandle)
                    ) {
                        val blissFrameLayout = prepareLauncherItem(updatedAppItem)
                        gridLayout.removeViewAt(j)
                        addAppToGrid(gridLayout, blissFrameLayout, j)
                        moveTo = i + 1
                        return
                    }
                }
            }
        }

        addLauncherItem(updatedAppItem)
    }

    fun showApps(launcherItems: List<LauncherItem>) {
        mProgressBar.visibility = GONE
        if (isWobbling) {
            handleWobbling(false)
        }
        createUI(launcherItems)
        isUiDone = true
        createPageChangeListener()
        createFolderTitleListener()
        createDragListener()
        createWidgetsPage()
        createAppLibraryPage()
        createIndicator()
        createOrUpdateBadgeCount()
        allAppsDisplayed = true
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        events = EventRelay.getInstance()
        events?.subscribe(EventsObserverImpl(this))
    }

    private fun createOrUpdateBadgeCount() {
        compositeDisposableBag.add(
            NotificationRepository.getNotificationRepository().getNotifications()
                .subscribeWith(object : DisposableObserver<Set<String>>() {
                    override fun onNext(packages: Set<String>) {
                        mAppsWithNotifications = packages
                        updateBadges(mAppsWithNotifications)
                    }

                    override fun onError(e: Throwable) {
                        Toast.makeText(
                            this@LauncherActivity,
                            getString(R.string.toast_recreating_launcher),
                            Toast.LENGTH_SHORT
                        ).show()
                        e.printStackTrace()
                        recreate()
                    }

                    override fun onComplete() = Unit
                })
        )
    }

    private fun updateBadges(appsWithNotifications: Set<String>) {
        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                val gridLayout = mFolderAppsViewPager.getChildAt(i) as GridLayout
                for (j in 0 until gridLayout.childCount) {
                    val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                    val appItem = getAppDetails(viewGroup)
                    if (appItem.itemType != Constants.ITEM_TYPE_SHORTCUT) {
                        updateBadgeToApp(viewGroup, appItem, appsWithNotifications, true)
                    }
                }
            }
        }
        for (gridLayout in pages) {
            for (j in 0 until gridLayout.childCount) {
                val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                val appItem = getAppDetails(viewGroup)
                if (appItem.itemType != Constants.ITEM_TYPE_SHORTCUT) {
                    updateBadgeToApp(viewGroup, appItem, appsWithNotifications, true)
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val viewGroup = mDock.getChildAt(i) as BlissFrameLayout
            val appItem = getAppDetails(viewGroup)
            if (appItem.itemType != Constants.ITEM_TYPE_SHORTCUT) {
                updateBadgeToApp(viewGroup, appItem, appsWithNotifications, false)
            }
        }
    }

    private fun updateBadgeToApp(
        viewGroup: BlissFrameLayout,
        appItem: LauncherItem,
        appsWithNotifications: Set<String>,
        withText: Boolean
    ) {
        if (appItem.itemType == Constants.ITEM_TYPE_FOLDER) {
            viewGroup.applyBadge(checkHasApp(appItem as FolderItem, appsWithNotifications), withText)
        } else {
            val applicationItem = appItem as ApplicationItem
            viewGroup.applyBadge(appsWithNotifications.contains(applicationItem.packageName), withText)
        }
    }

    private fun checkHasApp(appItem: FolderItem, packages: Set<String>): Boolean {
        for (item in appItem.items!!) {
            if (item.itemType == Constants.ITEM_TYPE_APPLICATION) {
                val applicationItem = item as ApplicationItem
                if (packages.contains(applicationItem.packageName)) {
                    return true
                }
            }
        }
        return false
    }

    private fun createFolderTitleListener() {
        mFolderTitleInput.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            }
            mFolderTitleInput.isCursorVisible = true
        }
        mFolderTitleInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                updateFolderTitle()
            }
            false
        }
        mFolderTitleInput.setOnClickListener { mFolderTitleInput.isCursorVisible = true }
        mFolderWindowContainer.setOnClickListener { returnToHomeScreen() }
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, 0)
    }

    private fun updateFolderTitle() {
        val updatedTitle = mFolderTitleInput.text.toString()
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        folder.title = updatedTitle
        val tags = folderView.tag as List<*>
        (tags[1] as TextView).text = updatedTitle
        mFolderTitleInput.setText(updatedTitle)
        mFolderTitleInput.isCursorVisible = false
    }

    private fun createPageChangeListener() {
        val navbarAnimator = createNavbarColorAnimator()

        mHorizontalPager.addOnScrollListener(object : HorizontalPager.OnScrollListener {
            var isViewScrolling = true

            override fun onScroll(scrollX: Int) {
                updatePageIndicatorScroll(scrollX)

                if (scrollX >= 0 && scrollX < mDeviceProfile.availableWidthPx) {
                    val fraction = (mDeviceProfile.availableWidthPx - scrollX).toFloat() /
                        mDeviceProfile.availableWidthPx
                    blurLayer.alpha = fraction
                }
                if (isViewScrolling) {
                    dragDropEnabled = false
                }
            }

            override fun onViewScrollFinished(page: Int) {
                isViewScrolling = false

                blurLayer.alpha = if (page == 0 || mFolderWindowContainer.visibility == VISIBLE) 1f else 0f

                if (currentPageNumber != page) {
                    val prevPage = currentPageNumber
                    currentPageNumber = page
                    navbarAnimator.cancel()
                    if (currentPageNumber == WIDGET_PAGE) {
                        navbarAnimator.start()
                        widgetsPage?.let { refreshSuggestedApps(it, forceRefreshSuggestedApps) }
                        mInsetsController.hide(WindowInsetsCompat.Type.statusBars())
                    } else if (prevPage == WIDGET_PAGE && currentPageNumber == 1) {
                        mInsetsController.show(WindowInsetsCompat.Type.statusBars())
                        navbarAnimator.reverse()
                    } else {
                        mInsetsController.show(WindowInsetsCompat.Type.statusBars())
                    }

                    dragDropEnabled = true
                    updateWorkspaceChromeForPage(currentPageNumber)
                    showPageIndicator(currentPageNumber)
                }
            }
        })
    }

    private fun createNavbarColorAnimator(): ValueAnimator {
        val navColor = window.navigationBarColor
        val colorAnimation = ValueAnimator.ofObject(
            ArgbEvaluator(),
            navColor,
            ColorUtils.setAlphaComponent(navColor, 160)
        )

        colorAnimation.duration = 400
        colorAnimation.interpolator = LinearInterpolator()
        colorAnimation.addUpdateListener { animator ->
            window.navigationBarColor = animator.animatedValue as Int
        }

        return colorAnimation
    }

    fun refreshSuggestedApps(viewGroup: ViewGroup, forceRefresh: Boolean) {
        val openUsageAccessSettingsTv = viewGroup.findViewById<TextView?>(R.id.openUsageAccessSettings)
        val suggestedAppsGridLayout = viewGroup.findViewById<GridLayout?>(R.id.suggestedAppGrid)
        if (!SuggestedAppsViewPolicy.hasRequiredViews(openUsageAccessSettingsTv, suggestedAppsGridLayout)) {
            return
        }
        val appUsageStats = AppUsageStats(this)
        val usageStats = appUsageStats.getUsageStats()

        if (usageStats.isEmpty()) {
            openUsageAccessSettingsTv!!.visibility = VISIBLE
            suggestedAppsGridLayout!!.visibility = GONE
            mSuggestedApps = ArrayList()
            return
        }

        openUsageAccessSettingsTv!!.visibility = GONE
        suggestedAppsGridLayout!!.visibility = VISIBLE

        val suggestedApps = usageStats
            .map { it.packageName }
            .mapNotNull { AppUtils.createAppItem(this, it, UserHandle()) }
            .take(4)

        if (!forceRefresh && suggestedApps == mSuggestedApps) {
            return
        }

        suggestedAppsGridLayout.removeAllViews()
        suggestedApps.map { prepareSuggestedApp(it) }.forEach { addAppToGrid(suggestedAppsGridLayout, it) }
        mSuggestedApps = suggestedApps
        forceRefreshSuggestedApps = false
    }

    private fun createUI(launcherItems: List<LauncherItem>) {
        mHorizontalPager.setUiCreated(false)
        mDock.isEnabled = false
        currentLauncherItems = ArrayList(launcherItems)

        pages = ArrayList()

        var hotseatCell = 0

        var workspaceScreen = preparePage()
        pages.add(workspaceScreen)

        mHorizontalPager.removeAllViews()
        mDock.removeAllViews()

        for (launcherItem in launcherItems) {
            val appView = prepareLauncherItem(launcherItem)
            if (launcherItem.container == Constants.CONTAINER_HOTSEAT.toLong()) {
                addAppToDock(appView, launcherItem.cell)
                if (launcherItem.cell == -1) {
                    launcherItem.cell = hotseatCell
                    hotseatCell++
                } else {
                    hotseatCell = launcherItem.cell
                }
            } else if (launcherItem.container == Constants.CONTAINER_DESKTOP.toLong()) {
                if (workspaceScreen.childCount >= mDeviceProfile.maxAppsPerPage ||
                    launcherItem.screenId > pages.size - 1
                ) {
                    workspaceScreen = preparePage()
                    pages.add(workspaceScreen)
                }
                launcherItem.screenId = (pages.size - 1).toLong()
                launcherItem.cell = workspaceScreen.childCount
                addAppToGrid(workspaceScreen, appView)
            }
        }

        for (page in pages) {
            mHorizontalPager.addView(page)
        }
        currentPageNumber = 0

        mHorizontalPager.setUiCreated(true)
        mDock.isEnabled = true
        setUpSwipeSearchContainer()
    }

    @SuppressLint("InflateParams")
    private fun preparePage(): GridLayout {
        val grid = layoutInflater.inflate(R.layout.apps_page, null) as GridLayout
        grid.rowCount = mDeviceProfile.numRows
        grid.columnCount = mDeviceProfile.numColumns
        grid.layoutTransition = getDefaultLayoutTransition()
        val horizontalPagePadding = Utilities.pxFromDp(4, this).toInt()
        grid.setPadding(horizontalPagePadding, 0, horizontalPagePadding, Utilities.pxFromDp(8, this).toInt())

        grid.setOnClickListener { handleWobbling(false) }
        grid.setOnLongClickListener { view ->
            if (!isWobbling) {
                showWorkspaceOptions(view)
                true
            } else {
                false
            }
        }

        return grid
    }

    private fun createWidgetsPage() {
        widgetsPage = layoutInflater.inflate(R.layout.widgets_page, mHorizontalPager, false) as FrameLayout
        val page = widgetsPage ?: return
        widgetContainer = page.findViewById(R.id.widget_container)
        mHorizontalPager.addView(page, 0)
        page.setOnDragListener(null)
        val scrollView = page.findViewById<ScrollView>(R.id.widgets_scroll_container)
        scrollView.setOnTouchListener { _, _ ->
            if (page.findViewById<View>(R.id.widget_resizer_container).visibility == VISIBLE) {
                hideWidgetResizeContainer()
            }
            false
        }
        currentPageNumber = 1
        mHorizontalPager.setCurrentPage(currentPageNumber)

        page.findViewById<View?>(R.id.edit_widgets_button)?.setOnClickListener {
            startActivity(Intent(this, WidgetsActivity::class.java))
        }

        if (WeatherUtils.isWeatherServiceAvailable(this)) {
            startService(Intent(this, WeatherSourceListenerService::class.java))
            startService(Intent(this, DeviceStatusService::class.java))
        }

        if (!Preferences.useCustomWeatherLocation(this)) {
            if (!WeatherPreferences.hasLocationPermission(this)) {
                requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    WeatherPreferences.LOCATION_PERMISSION_REQUEST_CODE
                )
            } else {
                val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                if (!lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER) && Preferences.getEnableLocation(this)) {
                    showLocationEnableDialog()
                    Preferences.setEnableLocation(this)
                } else {
                    startService(
                        Intent(this, WeatherUpdateService::class.java)
                            .setAction(WeatherUpdateService.ACTION_FORCE_UPDATE)
                    )
                }
            }
        } else {
            startService(
                Intent(this, WeatherUpdateService::class.java)
                    .setAction(WeatherUpdateService.ACTION_FORCE_UPDATE)
            )
        }

        rebindWidgetHost()
    }

    @SuppressLint("InflateParams")
    private fun createAppLibraryPage() {
        appLibraryPage = layoutInflater.inflate(R.layout.app_library_page, mHorizontalPager, false) as FrameLayout
        val page = appLibraryPage ?: return
        val appLibraryGrid = page.findViewById<GridLayout>(R.id.app_library_grid)
        appLibraryGrid.columnCount = mDeviceProfile.numColumns
        appLibraryGrid.setPadding(0, 0, 0, 0)
        appLibraryGrid.removeAllViews()
        val appLibraryCellWidthPx = max(
            mDeviceProfile.numColumns,
            (mDeviceProfile.availableWidthPx - dp(52)) / mDeviceProfile.numColumns
        )

        for (launcherItem in currentLauncherItems) {
            if (launcherItem.container == Constants.CONTAINER_HOTSEAT.toLong() ||
                launcherItem.itemType == Constants.ITEM_TYPE_FOLDER
            ) {
                continue
            }
            val appView = prepareSuggestedApp(launcherItem)
            appView.findViewById<View>(R.id.app_label).visibility = VISIBLE
            addAppToGrid(appLibraryGrid, appView, EMPTY_LOCATION_DRAG, appLibraryCellWidthPx)
        }
        mHorizontalPager.addView(page)
    }

    private fun rebindWidgetHost() {
        val widgetIds = mAppWidgetHost.appWidgetIds
        compositeDisposableBag.add(
            DatabaseManager.getManager(this).getWidgets(widgetIds)
                .subscribeOn(Schedulers.from(AppExecutors.getInstance().diskIO()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::bindWidgets)
        )
    }

    fun rebindAllWidgets() {
        if (widgetsPage != null) {
            widgetContainer.removeAllViewsInLayout()
            rebindWidgetHost()
        }
    }

    private fun bindWidgets(widgets: List<WidgetItem>) {
        for (widget in widgets) {
            val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(widget.id) ?: continue

            val hostView = mAppWidgetHost.createView(applicationContext, widget.id, appWidgetInfo) as RoundedWidgetView
            hostView.setAppWidget(widget.id, appWidgetInfo)

            val widgetView = WidgetViewBuilder.create(this, hostView) ?: continue
            if (widget.height != 0) {
                val minHeight = hostView.appWidgetInfo.minResizeHeight
                val maxHeight = mDeviceProfile.availableHeightPx * 3 / 4
                val normalisedDifference = (maxHeight - minHeight) / 100
                widgetView.layoutParams.height = minHeight + (normalisedDifference * widget.height)
            }
            addWidgetToContainer(widgetView)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == WeatherPreferences.LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                if (!lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    showLocationEnableDialog()
                    Preferences.setEnableLocation(this)
                } else {
                    startService(
                        Intent(this, WeatherUpdateService::class.java)
                            .setAction(WeatherUpdateService.ACTION_FORCE_UPDATE)
                    )
                }
            }
        } else if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                BlurWallpaperProvider.getInstance(applicationContext).updateAsync()
            }
        }
    }

    private fun showNotifPermissionDeniedDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.perm_required)
        builder.setMessage(R.string.notification_badge_warning)
        builder.setPositiveButton(R.string.grant) { dialog, _ ->
            val showFragmentArgs = Bundle()
            showFragmentArgs.putString(EXTRA_FRAGMENT_ARG_KEY, notificationComponentName.flattenToString())
            if (permissionString == null || !permissionString!!.contains(packageName)) {
                dialog.dismiss()
                startActivity(
                    Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
                        .putExtra(EXTRA_FRAGMENT_ARG_KEY, notificationComponentName.flattenToString())
                        .putExtra(EXTRA_SHOW_FRAGMENT_ARGS, showFragmentArgs)
                )
                Preferences.setNotToAskForNotificationAccess(this)
                Preferences.setNotToShowNotificationDialog(this)
            }
        }
        builder.setNegativeButton(R.string.ignore) { dialog, _ ->
            Preferences.setNotToShowNotificationDialog(this)
            dialog.dismiss()
        }
        builder.setCancelable(false)

        builder.create().show()
    }

    private fun showLocationEnableDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.weather_retrieve_location_dialog_title)
        builder.setMessage(R.string.weather_retrieve_location_dialog_message)
        builder.setCancelable(false)
        builder.setPositiveButton(R.string.weather_retrieve_location_dialog_enable_button) { _, _ ->
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivityForResult(intent, REQUEST_LOCATION_SOURCE_SETTING)
        }
        builder.setNegativeButton(R.string.cancel, null)
        enableLocationDialog = builder.create()
        enableLocationDialog?.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_LOCATION_SOURCE_SETTING) {
            val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (!lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                Toast.makeText(this, getString(R.string.toast_custom_location), Toast.LENGTH_SHORT).show()
            } else {
                startService(
                    Intent(this, WeatherUpdateService::class.java)
                        .setAction(WeatherUpdateService.ACTION_FORCE_UPDATE)
                )
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun searchForQuery(charSequence: CharSequence): ObservableSource<SuggestionsResult> {
        val launcherItems = searchForLauncherItems(charSequence.toString()).subscribeOn(Schedulers.io())
        val networkItems = searchForNetworkItems(charSequence).subscribeOn(Schedulers.io())
        return launcherItems.mergeWith(networkItems)
    }

    private fun searchForLauncherItems(charSequence: CharSequence): Observable<SuggestionsResult> {
        val query = Utilities.stripCaseAndAccents(charSequence.toString())
        val suggestionsResult = SuggestionsResult(query)
        val launcherItems = mutableListOf<LauncherItem>()
        pages.forEach { gridLayout ->
            for (i in 0 until gridLayout.childCount) {
                val blissFrameLayout = gridLayout.getChildAt(i) as BlissFrameLayout
                val launcherItem = blissFrameLayout.launcherItem
                if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                    val folderItem = launcherItem as FolderItem
                    for (item in folderItem.items!!) {
                        if (Utilities.stripCaseAndAccents(item.title.toString()).contains(query)) {
                            launcherItems.add(item)
                        }
                    }
                } else if (Utilities.stripCaseAndAccents(launcherItem.title.toString()).contains(query)) {
                    launcherItems.add(launcherItem)
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val blissFrameLayout = mDock.getChildAt(i) as BlissFrameLayout
            val launcherItem = blissFrameLayout.launcherItem
            if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = launcherItem as FolderItem
                for (item in folderItem.items!!) {
                    if (Utilities.stripCaseAndAccents(item.title.toString()).contains(query)) {
                        launcherItems.add(item)
                    }
                }
            } else if (Utilities.stripCaseAndAccents(launcherItem.title.toString()).contains(query)) {
                launcherItems.add(launcherItem)
            }
        }

        launcherItems.sortBy { it.title.toString().lowercase(Locale.getDefault()).indexOf(query) }

        suggestionsResult.setLauncherItems(if (launcherItems.size > 4) {
            launcherItems.subList(0, 4)
        } else {
            launcherItems
        })
        return Observable.just(suggestionsResult).onErrorReturn {
            suggestionsResult.setLauncherItems(ArrayList())
            suggestionsResult
        }
    }

    private fun searchForNetworkItems(charSequence: CharSequence): Observable<SuggestionsResult> {
        val query = charSequence.toString().lowercase(Locale.getDefault()).trim()
        val suggestionProvider = SearchSuggestionUtil().getSuggestionProvider(this)
        return suggestionProvider.query(query).toObservable()
    }

    override fun onClick(suggestion: String) {
        mSearchInput?.setText(suggestion)
        runSearch(suggestion)
        mSearchInput?.clearFocus()
        mSearchInput?.setText("")
    }

    private fun runSearch(query: String) {
        val intent = Intent(Intent.ACTION_VIEW, SearchSuggestionUtil().getUriForQuery(this, query))
        startActivity(intent)
    }

    private fun getCurrentAppsPageNumber(): Int {
        if (pages.isEmpty()) {
            return 0
        }
        return max(0, min(currentPageNumber - 1, pages.size - 1))
    }

    fun addAppToGrid(page: GridLayout, view: BlissFrameLayout) {
        addAppToGrid(page, view, EMPTY_LOCATION_DRAG)
    }

    private fun addAppToGrid(page: GridLayout, view: BlissFrameLayout, index: Int) {
        addAppToGrid(page, view, index, mDeviceProfile.cellWidthPx)
    }

    private fun addAppToGrid(page: GridLayout, view: BlissFrameLayout, index: Int, cellWidthPx: Int) {
        val rowSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val colSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val iconLayoutParams = GridLayout.LayoutParams(rowSpec, colSpec)
        iconLayoutParams.height = mDeviceProfile.cellHeightPx
        iconLayoutParams.width = cellWidthPx
        view.findViewById<View>(R.id.app_label).visibility = VISIBLE
        view.layoutParams = iconLayoutParams
        view.setWithText(true)
        if (index == EMPTY_LOCATION_DRAG || index == LauncherItem.INVALID_CELL || index > page.childCount) {
            page.addView(view)
        } else {
            page.addView(view, index)
        }
    }

    private fun addAppToDock(view: BlissFrameLayout, index: Int) {
        view.findViewById<View>(R.id.app_label).visibility = GONE
        val rowSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val colSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val iconLayoutParams = GridLayout.LayoutParams(rowSpec, colSpec)
        iconLayoutParams.height = mDeviceProfile.hotseatCellHeightPx
        iconLayoutParams.width = mDeviceProfile.hotseatCellWidthPx
        iconLayoutParams.setGravity(Gravity.CENTER)
        view.layoutParams = iconLayoutParams
        view.setWithText(false)
        if (index == LauncherItem.INVALID_CELL || index == EMPTY_LOCATION_DRAG || index > mDock.childCount) {
            mDock.addView(view)
        } else {
            mDock.addView(view, index)
        }
    }

    @SuppressLint("InflateParams", "ClickableViewAccessibility")
    private fun prepareLauncherItem(launcherItem: LauncherItem): BlissFrameLayout {
        val iconView = layoutInflater.inflate(R.layout.app_view, null) as BlissFrameLayout
        iconView.launcherItem = launcherItem
        val icon = iconView.findViewById<SquareFrameLayout>(R.id.app_icon)
        if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
            iconView.applyBadge(
                checkHasApp(launcherItem as FolderItem, mAppsWithNotifications),
                launcherItem.container != Constants.CONTAINER_HOTSEAT.toLong()
            )
        } else if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            val applicationItem = launcherItem as ApplicationItem
            if (applicationItem.appType == ApplicationItem.TYPE_CALENDAR) {
                mCalendarIcons.add(iconView)
            }
            iconView.applyBadge(
                mAppsWithNotifications.contains(applicationItem.packageName),
                launcherItem.container != Constants.CONTAINER_HOTSEAT.toLong()
            )
        }

        icon.setOnLongClickListener { view ->
            view.isHapticFeedbackEnabled = true
            if (isWobbling) {
                longPressed = true
            } else {
                showLauncherItemOptions(launcherItem, iconView, view)
            }
            true
        }

        icon.setOnTouchListener(object : View.OnTouchListener {
            private var iconPressedAt = 0L

            override fun onTouch(view: View, event: MotionEvent): Boolean {
                if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                    if (!mLongClickStartsDrag) {
                        iconPressedAt = System.currentTimeMillis()
                    }
                } else if (event.actionMasked == MotionEvent.ACTION_MOVE) {
                    if (longPressed || (!mLongClickStartsDrag && System.currentTimeMillis() - iconPressedAt > 150)) {
                        longPressed = false
                        movingApp = iconView
                        dragShadowBuilder = BlissDragShadowBuilder(
                            icon,
                            if (event.x < 0) 0f else event.x,
                            if (event.y < 0) 0f else event.y
                        )
                        icon.startDragAndDrop(null, dragShadowBuilder, iconView, 0)
                        parentPage = if ((iconView.parent as View).parent is HorizontalPager) {
                            getCurrentAppsPageNumber()
                        } else {
                            -99
                        }
                        iconView.clearAnimation()
                        movingApp?.visibility = View.INVISIBLE
                        dragDropEnabled = true
                    }
                } else if (event.action == MotionEvent.ACTION_UP) {
                    Handler(Looper.getMainLooper()).post {
                        if (movingApp != null && movingApp?.visibility != VISIBLE) {
                            movingApp?.visibility = VISIBLE
                            movingApp?.invalidate()
                        }
                    }
                    return false
                }
                return false
            }
        })

        icon.setOnClickListener { view ->
            if (isWobbling) {
                handleWobbling(false)
                return@setOnClickListener
            }

            openLauncherItem(launcherItem, iconView, view)
        }

        return iconView
    }

    private fun openLauncherItem(launcherItem: LauncherItem, iconView: BlissFrameLayout, view: View) {
        if (launcherItem.itemType != Constants.ITEM_TYPE_FOLDER) {
            startActivitySafely(applicationContext, launcherItem, view)
        } else {
            folderFromDock = !((iconView.parent as View).parent is HorizontalPager)
            displayFolder(launcherItem as FolderItem, iconView)
        }
    }

    private fun showLauncherItemOptions(launcherItem: LauncherItem, iconView: BlissFrameLayout, anchor: View) {
        showLauncherOptionsPopup(anchor, launcherItem, iconView)
    }

    private fun showWorkspaceOptions(anchor: View) {
        handleWobbling(true)
    }

    private fun showLauncherOptionsPopup(anchor: View, launcherItem: LauncherItem, iconView: BlissFrameLayout) {
        dismissLauncherOptionsPopup()

        val menu = layoutInflater.inflate(R.layout.popup_launcher_app_options, null)

        menu.findViewById<View?>(R.id.appInfoButton)?.setOnClickListener {
            dismissLauncherOptionsPopup()
            if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                openLauncherItem(launcherItem, iconView, anchor)
            } else {
                openLauncherItemInfo(launcherItem)
            }
        }

        menu.findViewById<View?>(R.id.hideButton)?.setOnClickListener { dismissLauncherOptionsPopup() }

        menu.findViewById<View?>(R.id.editHomeButton)?.setOnClickListener {
            dismissLauncherOptionsPopup()
            handleWobbling(true)
        }

        menu.findViewById<View?>(R.id.deleteButton)?.setOnClickListener {
            dismissLauncherOptionsPopup()
            if (canShowUninstallOption(launcherItem)) {
                uninstallLauncherItem(launcherItem, iconView)
            } else {
                handleWobbling(true)
            }
        }

        launcherOptionsPopup = PopupWindow(menu, dp(262), ViewGroup.LayoutParams.WRAP_CONTENT, true).apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isOutsideTouchable = true
            elevation = dp(12).toFloat()
            setOnDismissListener {
                hideSelectedIconPreview()
                contextOverlay.animate().alpha(0f).setDuration(120L).withEndAction {
                    contextOverlay.visibility = GONE
                    contextOverlay.alpha = 1f
                }.start()
                launcherOptionsPopup = null
            }
        }

        menu.measure(
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.widthPixels, View.MeasureSpec.AT_MOST),
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.heightPixels, View.MeasureSpec.AT_MOST)
        )

        contextOverlay.animate().cancel()
        contextOverlay.alpha = 0f
        contextOverlay.visibility = VISIBLE
        contextOverlay.bringToFront()
        contextOverlay.animate().alpha(1f).setDuration(120L).start()
        showSelectedIconPreview(launcherItem, anchor)
        launcherOptionsPopup?.showAtLocation(
            mLauncherView,
            Gravity.NO_GRAVITY,
            popupX(anchor, dp(262)),
            popupY(anchor, menu.measuredHeight)
        )
    }

    private fun dismissLauncherOptionsPopup() {
        val popup = launcherOptionsPopup
        if (popup != null) {
            launcherOptionsPopup = null
            popup.dismiss()
        } else {
            hideSelectedIconPreview()
            contextOverlay.visibility = GONE
            contextOverlay.alpha = 1f
        }
    }

    private fun showSelectedIconPreview(launcherItem: LauncherItem, anchor: View?) {
        val preview = mLauncherView.findViewById<View?>(R.id.selectedIconPreview)
        if (preview == null || anchor == null || anchor === mLauncherView) {
            return
        }

        preview.findViewById<ImageView?>(R.id.selectedIconImage)?.setImageDrawable(launcherItem.icon)
        preview.findViewById<TextView?>(R.id.selectedIconLabel)?.text = launcherItem.title

        val anchorLocation = IntArray(2)
        val rootLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        mLauncherView.getLocationOnScreen(rootLocation)

        val previewWidth = if (preview.width > 0) preview.width else dp(94)
        val previewHeight = if (preview.height > 0) preview.height else dp(118)
        val rootWidth = if (mLauncherView.width > 0) mLauncherView.width else resources.displayMetrics.widthPixels
        val rootHeight = if (mLauncherView.height > 0) mLauncherView.height else resources.displayMetrics.heightPixels
        val minMargin = dp(4)
        val topMargin = dp(12)
        val left = anchorLocation[0] - rootLocation[0] + anchor.width / 2 - previewWidth / 2
        val top = anchorLocation[1] - rootLocation[1] - dp(2)
        val maxLeft = max(minMargin, rootWidth - previewWidth - minMargin)
        val maxTop = max(topMargin, rootHeight - previewHeight - topMargin)

        preview.x = max(minMargin, min(left, maxLeft)).toFloat()
        preview.y = max(topMargin, min(top, maxTop)).toFloat()
        preview.bringToFront()
        preview.animate().cancel()
        preview.alpha = 0f
        preview.scaleX = 1.03f
        preview.scaleY = 1.03f
        preview.visibility = VISIBLE
        preview.animate()
            .alpha(1f)
            .scaleX(1.08f)
            .scaleY(1.08f)
            .setDuration(120L)
            .start()
    }

    private fun hideSelectedIconPreview() {
        val preview = mLauncherView.findViewById<View?>(R.id.selectedIconPreview)
        if (preview == null || preview.visibility != VISIBLE) {
            return
        }
        preview.animate().cancel()
        preview.animate()
            .alpha(0f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(110L)
            .withEndAction {
                preview.visibility = GONE
                preview.alpha = 1f
            }
            .start()
    }

    private fun popupX(anchor: View, popupWidth: Int): Int {
        val anchorLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        val screenWidth = resources.displayMetrics.widthPixels
        val margin = dp(16)
        return max(margin, min(anchorLocation[0], screenWidth - popupWidth - margin))
    }

    private fun popupY(anchor: View, popupHeight: Int): Int {
        val anchorLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        val screenHeight = resources.displayMetrics.heightPixels
        val margin = dp(16)
        val desiredY = anchorLocation[1] + anchor.height + dp(8)
        return if (desiredY + popupHeight > screenHeight - margin) {
            max(margin, anchorLocation[1] - popupHeight - dp(8))
        } else {
            desiredY
        }
    }

    private fun dp(value: Int): Int = Utilities.pxFromDp(value.toFloat(), resources.displayMetrics)

    private fun canShowUninstallOption(launcherItem: LauncherItem): Boolean {
        if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
            return true
        }
        if (launcherItem.itemType != Constants.ITEM_TYPE_APPLICATION) {
            return false
        }
        val applicationItem = launcherItem as ApplicationItem
        return applicationItem.isSystemApp == ApplicationItem.FLAG_SYSTEM_UNKNOWN ||
            (applicationItem.isSystemApp and ApplicationItem.FLAG_SYSTEM_NO) != 0
    }

    private fun openLauncherItemInfo(launcherItem: LauncherItem) {
        val packageName = launcherItem.getTargetComponent()?.packageName
            ?: when (launcherItem.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> (launcherItem as ApplicationItem).packageName
                Constants.ITEM_TYPE_SHORTCUT -> (launcherItem as ShortcutItem).packageName
                else -> null
            }

        if (packageName == null) {
            Toast.makeText(this, getString(R.string.activity_not_found), Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            .setData(Uri.parse("package:$packageName"))
        startActivity(intent)
    }

    private fun uninstallLauncherItem(launcherItem: LauncherItem, blissFrameLayout: BlissFrameLayout) {
        if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            val componentName = launcherItem.getTargetComponent()
            if (componentName == null) {
                Toast.makeText(this, getString(R.string.toast_cannot_uninstall), Toast.LENGTH_SHORT).show()
            } else {
                val packageUri = Uri.fromParts("package", componentName.packageName, componentName.className)
                val intent = Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri)
                    .putExtra(Intent.EXTRA_USER, launcherItem.user!!.getRealHandle())
                startActivity(intent)
            }
        } else if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
            val dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))
                .setTitle(launcherItem.title)
                .setMessage(R.string.uninstall_shortcut_dialog)
                .setPositiveButton(R.string.ok) { _, _ ->
                    val shortcut = launcherItem as ShortcutItem
                    if (shortcut.packageName != null) {
                        DeepShortcutManager.getInstance(this).unpinShortcut(ShortcutKey.fromItem(shortcut))
                        if (DeepShortcutManager.getInstance(this).wasLastCallSuccess()) {
                            deleteShortcutFromProvider(shortcut.id)
                            removeShortcutView(shortcut, blissFrameLayout)
                        }
                    } else {
                        deleteShortcutFromProvider(shortcut.id)
                        removeShortcutView(shortcut, blissFrameLayout)
                    }
                }
                .setNegativeButton(R.string.cancel, null)
                .setIcon(launcherItem.icon)
                .create()
            dialog.setOnShowListener {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.color_blue))
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.color_blue))
            }
            dialog.show()
        }
    }

    fun prepareSuggestedApp(launcherItem: LauncherItem): BlissFrameLayout {
        val view = layoutInflater.inflate(R.layout.app_view, null) as BlissFrameLayout
        view.launcherItem = launcherItem
        val icon = view.findViewById<SquareFrameLayout>(R.id.app_icon)

        if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            view.applyBadge(mAppsWithNotifications.contains((launcherItem as ApplicationItem).packageName), true)
        }
        icon.setOnClickListener { startActivitySafely(this, launcherItem, it) }
        return view
    }

    private fun startActivitySafely(context: Context, launcherItem: LauncherItem, v: View?) {
        val intent = launcherItem.getIntent() ?: return
        val user = launcherItem.user?.getRealHandle()

        if (v != null) {
            intent.sourceBounds = getViewBounds(v)
        }

        if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
            startShortcutIntentSafely(context, intent, launcherItem)
        } else {
            val applicationItem = launcherItem as ApplicationItem
            if (applicationItem.isDisabled) {
                Toast.makeText(this, getString(R.string.toast_package_unavailable), Toast.LENGTH_SHORT).show()
            } else {
                if (user == null || user == Process.myUserHandle()) {
                    context.startActivity(intent)
                } else {
                    (getSystemService(LAUNCHER_APPS_SERVICE) as LauncherApps).startMainActivity(
                        intent.component,
                        user,
                        intent.sourceBounds,
                        null
                    )
                }
            }
        }
    }

    private fun startShortcutIntentSafely(context: Context, intent: Intent, appItem: LauncherItem) {
        try {
            val oldPolicy = StrictMode.getVmPolicy()
            try {
                StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())

                if (appItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                    if (Utilities.ATLEAST_OREO) {
                        val packageName = intent.`package` ?: return
                        DeepShortcutManager.getInstance(context).startShortcut(
                            packageName,
                            appItem.id,
                            intent.sourceBounds,
                            null,
                            Process.myUserHandle()
                        )
                    } else {
                        context.startActivity(intent)
                    }
                } else {
                    context.startActivity(intent)
                }
            } finally {
                StrictMode.setVmPolicy(oldPolicy)
            }
        } catch (e: SecurityException) {
            if (intent.component == null &&
                Intent.ACTION_CALL == intent.action &&
                context.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PERMISSION_CALL_PHONE)
            } else {
                throw e
            }
        }
    }

    private fun getViewBounds(v: View): Rect {
        val pos = IntArray(2)
        v.getLocationOnScreen(pos)
        return Rect(pos[0], pos[1], pos[0] + v.width, pos[1] + v.height)
    }

    private fun handleWobbling(shouldPlay: Boolean) {
        if (mWobblingCountDownTimer != null && !shouldPlay) {
            mWobblingCountDownTimer?.cancel()
        }
        isWobbling = shouldPlay
        mLongClickStartsDrag = !shouldPlay
        longPressed = false

        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                toggleWobbleAnimation(mFolderAppsViewPager.getChildAt(i) as GridLayout, shouldPlay)
            }
        }

        for (page in pages) {
            toggleWobbleAnimation(page, shouldPlay)
        }
        toggleWobbleAnimation(mDock, shouldPlay)
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        if (shouldPlay && isHomePage(currentPageNumber)) {
            showDotsInIndicator(homePagePositionForPagerPage(currentPageNumber), false)
        } else {
            indicatorMode = IndicatorMode.SEARCH
            updateWorkspaceChromeForPage(currentPageNumber)
        }
    }

    private fun toggleWobbleAnimation(gridLayout: GridLayout, shouldPlayAnimation: Boolean) {
        for (i in 0 until gridLayout.childCount) {
            val blissFrameLayout = gridLayout.getChildAt(i) as BlissFrameLayout
            makeAppWobble(blissFrameLayout, shouldPlayAnimation, i)
        }
    }

    private fun makeAppWobble(blissFrameLayout: BlissFrameLayout?, shouldPlayAnimation: Boolean, i: Int) {
        if (blissFrameLayout == null) {
            return
        }
        val userManager = getSystemService(Context.USER_SERVICE) as UserManager
        val restrictions = userManager.userRestrictions
        val uninstallDisabled = restrictions.getBoolean(UserManager.DISALLOW_APPS_CONTROL, false) ||
            restrictions.getBoolean(UserManager.DISALLOW_UNINSTALL_APPS, false)
        if (shouldPlayAnimation) {
            if (blissFrameLayout.animation == null) {
                val imageView = blissFrameLayout.findViewById<ImageView?>(R.id.uninstall_app)
                if (imageView == null && !uninstallDisabled) {
                    Handler(Looper.getMainLooper()).post { addUninstallIcon(blissFrameLayout) }
                }

                if (i % 2 == 0) {
                    blissFrameLayout.startAnimation(wobbleAnimation)
                } else {
                    blissFrameLayout.startAnimation(wobbleReverseAnimation)
                }
            }
        } else {
            blissFrameLayout.clearAnimation()
            Handler(Looper.getMainLooper()).post { removeUninstallIcon(blissFrameLayout) }
        }
    }

    private fun removeUninstallIcon(blissFrameLayout: BlissFrameLayout?) {
        val imageView = blissFrameLayout?.findViewById<ImageView?>(R.id.uninstall_app)
        if (imageView != null) {
            (imageView.parent as ViewGroup).removeView(imageView)
        }
    }

    private fun addUninstallIcon(blissFrameLayout: BlissFrameLayout) {
        val launcherItem = getAppDetails(blissFrameLayout)
        if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
            return
        }

        if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            val applicationItem = launcherItem as ApplicationItem
            if (applicationItem.isSystemApp != ApplicationItem.FLAG_SYSTEM_UNKNOWN) {
                if ((applicationItem.isSystemApp and ApplicationItem.FLAG_SYSTEM_NO) == 0) {
                    return
                }
            }
        }

        val appIcon = blissFrameLayout.findViewById<SquareFrameLayout>(R.id.app_icon)
        val size = mDeviceProfile.uninstallIconSizePx
        val topPadding = if (appIcon.top - mDeviceProfile.uninstallIconSizePx / 2 +
            mDeviceProfile.uninstallIconPadding > 0
        ) {
            appIcon.top - mDeviceProfile.uninstallIconSizePx / 2 + mDeviceProfile.uninstallIconPadding
        } else {
            0
        }
        val bottomPadding = topPadding
        val rightPadding = if (appIcon.left - mDeviceProfile.uninstallIconSizePx / 2 +
            mDeviceProfile.uninstallIconPadding > 0
        ) {
            appIcon.left - mDeviceProfile.uninstallIconSizePx / 2 + mDeviceProfile.uninstallIconPadding
        } else {
            0
        }
        val leftPadding = rightPadding

        val imageView = ImageView(this)
        imageView.id = R.id.uninstall_app
        imageView.setImageResource(R.drawable.remove_icon_72)
        imageView.setPadding(leftPadding, topPadding, rightPadding, bottomPadding)

        imageView.setOnClickListener { uninstallLauncherItem(launcherItem, blissFrameLayout) }
        val layoutParams = FrameLayout.LayoutParams(size + 2 * rightPadding, size + 2 * topPadding)
        layoutParams.gravity = Gravity.END or Gravity.TOP
        blissFrameLayout.addView(imageView, layoutParams)
    }

    private fun deleteShortcutFromProvider(id: String) {
        val count = contentResolver.delete(
            Uri.parse("content://foundation.e.pwaplayer.provider/pwa"),
            null,
            arrayOf(id)
        )
        Timber.tag("LauncherActivity").d("Items deleted from pwa provider: $count")
    }

    private fun removeShortcutView(shortcutItem: ShortcutItem, blissFrameLayout: BlissFrameLayout) {
        DatabaseManager.getManager(this).removeLauncherItem(shortcutItem.id)
        if (mFolderWindowContainer.visibility == VISIBLE) {
            val folder = activeFolder ?: return
            val folderView = activeFolderView ?: return
            folder.items!!.remove(shortcutItem)
            mFolderAppsViewPager.adapter?.notifyDataSetChanged()
            blissFrameLayout.clearAnimation()
            (blissFrameLayout.parent as ViewGroup).removeView(blissFrameLayout)
            if (folder.items!!.isEmpty()) {
                (folderView.parent as ViewGroup).removeView(folderView)
                hideFolderWindowContainer()
            } else if (folder.items!!.size == 1) {
                val item = folder.items!![0]
                folder.items!!.remove(item)
                mFolderAppsViewPager.adapter?.notifyDataSetChanged()
                val view = prepareLauncherItem(item)

                if (folderFromDock) {
                    addAppToDock(view, mDock.indexOfChild(folderView))
                } else {
                    val gridLayout = pages[getCurrentAppsPageNumber()]
                    addAppToGrid(gridLayout, view, gridLayout.indexOfChild(folderView))
                }
                folderView.clearAnimation()
                (folderView.parent as ViewGroup).removeView(folderView)
                hideFolderWindowContainer()
            } else {
                updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                hideFolderWindowContainer()
            }
        } else {
            blissFrameLayout.clearAnimation()
            (blissFrameLayout.parent as ViewGroup).removeView(blissFrameLayout)
        }
    }

    private fun createDragListener() {
        mDock.setOnDragListener(object : View.OnDragListener {
            var cX = 0f
            var cY = 0f
            private var latestFolderInterest = false

            override fun onDrag(view: View, dragEvent: DragEvent): Boolean {
                val moving = movingApp
                val shadow = dragShadowBuilder
                if (dragEvent.action == DragEvent.ACTION_DRAG_STARTED) {
                    isDragging = true
                    mWobblingCountDownTimer?.cancel()
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_LOCATION) {
                    if (moving == null || shadow == null) return true
                    if (getAppDetails(moving).container != Constants.CONTAINER_DESKTOP.toLong() &&
                        getAppDetails(moving).container != Constants.CONTAINER_HOTSEAT.toLong()
                    ) {
                        return true
                    }

                    if (!dragDropEnabled) {
                        return true
                    }

                    cX = dragEvent.x - shadow.xOffset
                    cY = mDock.y + dragEvent.y - shadow.yOffset

                    val index = getIndex(mDock, cX, cY)

                    if (index == mDock.indexOfChild(moving)) {
                        discardCollidingApp()
                        return true
                    }

                    if (index == EMPTY_LOCATION_DRAG) {
                        discardCollidingApp()
                    } else {
                        val latestCollidingApp = mDock.getChildAt(index) as BlissFrameLayout
                        if (collidingApp !== latestCollidingApp) {
                            collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                            collidingApp = latestCollidingApp
                            folderInterest = false
                        }

                        val movingLauncherItem = moving.launcherItem
                        if (movingLauncherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                            folderInterest = false
                        } else {
                            latestFolderInterest = checkIfFolderInterest(mDock, index, cX, cY)
                            if (latestFolderInterest != folderInterest) {
                                folderInterest = latestFolderInterest
                            }
                            if (folderInterest) {
                                cleanupDockReorder(true)
                                cleanupReorder(true)
                                makeAppHot(collidingApp)
                            } else {
                                collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                            }
                        }
                    }

                    if (!folderInterest && !mDockReorderAlarm.alarmPending()) {
                        val dockReorderAlarmListener = DockReorderAlarmListener(index)
                        mDockReorderAlarm.setOnAlarmListener(dockReorderAlarmListener)
                        mDockReorderAlarm.setAlarm(REORDER_TIMEOUT.toLong())
                    }
                    return true
                } else if (dragEvent.action == DragEvent.ACTION_DROP) {
                    if (moving == null || shadow == null) return true
                    cleanupDockReorder(true)
                    cleanupReorder(true)
                    if (mFolderWindowContainer.visibility != VISIBLE) {
                        if (!folderInterest) {
                            if (moving.parent == null) {
                                if (mDock.childCount >= mDeviceProfile.numColumns) {
                                    Toast.makeText(
                                        this@LauncherActivity,
                                        getString(R.string.toast_dock_full),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    addAppToDock(moving, EMPTY_LOCATION_DRAG)
                                }
                            }
                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, mDock.indexOfChild(moving))
                        } else {
                            if ((collidingApp?.parent as? View)?.parent is HorizontalPager) {
                                createOrUpdateFolder(false)
                            } else {
                                createOrUpdateFolder(true)
                            }
                            folderInterest = false
                        }
                    } else {
                        cX = dragEvent.x - shadow.xOffset
                        cY = mDock.y + dragEvent.y - shadow.yOffset
                        val topLeftCorner = IntArray(2)
                        mFolderAppsViewPager.getLocationOnScreen(topLeftCorner)
                        val left = topLeftCorner[0]
                        val top = topLeftCorner[1]
                        val right = left + mFolderAppsViewPager.width
                        val bottom = top + mFolderAppsViewPager.height

                        if (!(left < right && top < bottom && cX >= left && cX < right && cY >= top && cY < bottom)) {
                            removeAppFromFolder()
                        } else {
                            moving.visibility = VISIBLE
                            val currentItem = mFolderAppsViewPager.currentItem
                            makeAppWobble(
                                moving,
                                true,
                                (mFolderAppsViewPager.getChildAt(currentItem) as GridLayout).indexOfChild(moving)
                            )
                        }
                    }
                    return true
                }

                return true
            }
        })

        mHorizontalPager.setOnDragListener(object : View.OnDragListener {
            var cY = 0f
            var cX = 0f
            private var latestFolderInterest = false

            override fun onDrag(view: View, dragEvent: DragEvent): Boolean {
                val moving = movingApp
                val shadow = dragShadowBuilder
                if (dragEvent.action == DragEvent.ACTION_DRAG_STARTED) {
                    isDragging = true
                    mWobblingCountDownTimer?.cancel()
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_LOCATION) {
                    if (moving == null || shadow == null) return true
                    cX = dragEvent.x - shadow.xOffset
                    cY = mHorizontalPager.y + dragEvent.y - shadow.yOffset

                    if (getAppDetails(moving).container != Constants.CONTAINER_DESKTOP.toLong() &&
                        getAppDetails(moving).container != Constants.CONTAINER_HOTSEAT.toLong()
                    ) {
                        return true
                    }

                    if (!dragDropEnabled) {
                        return true
                    }

                    val page = pages[getCurrentAppsPageNumber()]

                    if (cX - mDeviceProfile.iconSizePx / 10 > mDeviceProfile.availableWidthPx - 2 * scrollCorner) {
                        if (getCurrentAppsPageNumber() + 1 < pages.size) {
                            mHorizontalPager.scrollRight(300)
                        } else if (getCurrentAppsPageNumber() + 1 == pages.size &&
                            getGridFromPage(page).childCount > 1
                        ) {
                            val layout = preparePage()
                            pages.add(layout)
                            val appLibraryIndex = if (appLibraryPage == null) {
                                mHorizontalPager.childCount
                            } else {
                                max(0, mHorizontalPager.childCount - 1)
                            }
                            mHorizontalPager.addView(layout, appLibraryIndex)
                            refreshPageIndicator()
                        }
                    } else if (cX + mDeviceProfile.iconSizePx / 10 < 2 * scrollCorner) {
                        if (getCurrentAppsPageNumber() == 0) {
                            return true
                        }
                        if (getCurrentAppsPageNumber() - 1 >= 0) {
                            mHorizontalPager.scrollLeft(300)
                        } else if (getCurrentAppsPageNumber() + 1 == pages.size - 2 &&
                            getGridFromPage(pages[pages.size - 1]).childCount <= 0
                        ) {
                            mHorizontalPager.removeViewAt(pages.size)
                            pages.removeAt(pages.size - 1)
                            refreshPageIndicator()
                        }
                    } else {
                        val index = getIndex(page, cX, cY)
                        if (index == getGridFromPage(page).indexOfChild(moving)) {
                            discardCollidingApp()
                            return true
                        }

                        if (index == EMPTY_LOCATION_DRAG) {
                            discardCollidingApp()
                        } else {
                            val latestCollidingApp = getGridFromPage(page).getChildAt(index)
                            if (collidingApp !== latestCollidingApp) {
                                collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                                collidingApp = latestCollidingApp as BlissFrameLayout
                                folderInterest = false
                            }

                            if (getAppDetails(moving).itemType == Constants.ITEM_TYPE_FOLDER) {
                                folderInterest = false
                            } else {
                                latestFolderInterest = checkIfFolderInterest(
                                    getGridFromPage(pages[getCurrentAppsPageNumber()]),
                                    index,
                                    cX,
                                    cY
                                )

                                if (latestFolderInterest != folderInterest) {
                                    folderInterest = latestFolderInterest
                                }
                                if (folderInterest) {
                                    cleanupReorder(true)
                                    cleanupDockReorder(true)
                                    makeAppHot(collidingApp)
                                } else {
                                    collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                                }
                            }
                        }

                        if (!folderInterest && !mReorderAlarm.alarmPending()) {
                            val reorderAlarmListener = ReorderAlarmListener(page, moving.parent as ViewGroup, index)
                            mReorderAlarm.setOnAlarmListener(reorderAlarmListener)
                            mReorderAlarm.setAlarm(REORDER_TIMEOUT.toLong())
                        }
                    }
                } else if (dragEvent.action == DragEvent.ACTION_DROP) {
                    if (moving == null || shadow == null) return true
                    cleanupReorder(true)
                    cleanupDockReorder(true)
                    if (mFolderWindowContainer.visibility != VISIBLE) {
                        val gridLayout = pages[getCurrentAppsPageNumber()]
                        if (!folderInterest) {
                            if (moving.parent == null) {
                                if (gridLayout.childCount < mDeviceProfile.maxAppsPerPage) {
                                    addAppToGrid(gridLayout, moving)
                                }
                            }

                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                        } else {
                            if ((collidingApp?.parent as? View)?.parent is HorizontalPager) {
                                createOrUpdateFolder(false)
                            } else {
                                createOrUpdateFolder(true)
                            }
                            folderInterest = false
                        }
                    } else {
                        cX = dragEvent.x - shadow.xOffset
                        cY = mHorizontalPager.y + dragEvent.y - shadow.yOffset

                        val topLeftCorner = IntArray(2)
                        mFolderAppsViewPager.getLocationOnScreen(topLeftCorner)
                        val left = topLeftCorner[0]
                        val top = topLeftCorner[1]
                        val right = left + mFolderAppsViewPager.width
                        val bottom = top + mFolderAppsViewPager.height

                        if (!(left < right && top < bottom && cX >= left && cX < right && cY >= top && cY < bottom)) {
                            removeAppFromFolder()
                        } else {
                            moving.visibility = VISIBLE
                            val currentItem = mFolderAppsViewPager.currentItem
                            val gridLayout = mFolderAppsViewPager.getChildAt(currentItem) as? GridLayout
                            if (gridLayout != null) {
                                makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                            }
                        }
                    }
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_ENDED) {
                    if (moving == null) return true
                    if (isDragging) {
                        isDragging = false
                    }

                    cleanupReorder(true)
                    cleanupDockReorder(true)

                    if (!dragEvent.result) {
                        if (mFolderWindowContainer.visibility == VISIBLE) {
                            val currentItem = mFolderAppsViewPager.currentItem
                            makeAppWobble(
                                moving,
                                true,
                                (mFolderAppsViewPager.getChildAt(currentItem) as GridLayout).indexOfChild(moving)
                            )
                        } else if ((moving.parent as View).parent is HorizontalPager) {
                            val gridLayout = pages[getCurrentAppsPageNumber()]
                            makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                        } else {
                            makeAppWobble(moving, true, mDock.indexOfChild(moving))
                        }
                    }

                    Handler(Looper.getMainLooper()).post {
                        moving.visibility = VISIBLE
                        movingApp = null
                    }

                    mWobblingCountDownTimer?.cancel()
                    mLongClickStartsDrag = false
                    mWobblingCountDownTimer = object : CountDownTimer(25000, 1000) {
                        override fun onTick(millisUntilFinished: Long) = Unit

                        override fun onFinish() {
                            if (isWobbling) {
                                handleWobbling(false)
                            }
                        }
                    }.start()

                    var i = 0
                    while (i < pages.size) {
                        if (pages[i].childCount <= 0) {
                            pages.removeAt(i)
                            mHorizontalPager.removeViewAt(i + 1)
                            if (i == pages.size) {
                                mHorizontalPager.scrollLeft(100)
                            }
                            refreshPageIndicator()
                            i--
                        }
                        i++
                    }
                    DatabaseManager.getManager(this@LauncherActivity).saveLayouts(pages, mDock)
                }

                return true
            }
        })
    }

    private fun cleanupDockReorder(cancelAlarm: Boolean) {
        if (cancelAlarm) {
            mDockReorderAlarm.cancelAlarm()
        }
    }

    private fun cleanupReorder(cancelAlarm: Boolean) {
        if (cancelAlarm) {
            mReorderAlarm.cancelAlarm()
        }
    }

    private fun removeAppFromFolder() {
        val moving = movingApp ?: return
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        if (pages[getCurrentAppsPageNumber()].childCount >= mDeviceProfile.maxAppsPerPage) {
            Toast.makeText(this, getString(R.string.toast_no_room), Toast.LENGTH_SHORT).show()
            moving.visibility = VISIBLE
            val currentItem = mFolderAppsViewPager.currentItem
            makeAppWobble(
                moving,
                true,
                (mFolderAppsViewPager.getChildAt(currentItem) as GridLayout).indexOfChild(moving)
            )
        } else {
            val app = getAppDetails(moving)
            folder.items!!.remove(app)
            mFolderAppsViewPager.adapter?.notifyDataSetChanged()
            app.container = if (folderFromDock) Constants.CONTAINER_HOTSEAT.toLong() else Constants.CONTAINER_DESKTOP.toLong()
            app.screenId = if (folderFromDock) -1 else currentPageNumber.toLong()

            if (folder.items!!.isEmpty()) {
                val view = prepareLauncherItem(app)
                if (folderFromDock) {
                    val index = mDock.indexOfChild(folderView)
                    removeUninstallIcon(folderView)
                    mDock.removeView(folderView)
                    addAppToDock(view, index)
                    makeAppWobble(view, true, index)
                } else {
                    val gridLayout = pages[getCurrentAppsPageNumber()]
                    val index = gridLayout.indexOfChild(folderView)
                    folderView.clearAnimation()
                    removeUninstallIcon(folderView)
                    gridLayout.removeView(folderView)
                    addAppToGrid(gridLayout, view, index)
                    makeAppWobble(view, true, index)
                }
                DatabaseManager.getManager(this).removeLauncherItem(folder.id)
            } else {
                if (folder.items!!.size == 1) {
                    val item = folder.items!![0]
                    folder.items!!.remove(item)
                    mFolderAppsViewPager.adapter?.notifyDataSetChanged()
                    item.container = if (folderFromDock) Constants.CONTAINER_HOTSEAT.toLong() else Constants.CONTAINER_DESKTOP.toLong()
                    item.screenId = if (folderFromDock) -1 else currentPageNumber.toLong()
                    val view = prepareLauncherItem(item)
                    if (folderFromDock) {
                        val index = mDock.indexOfChild(folderView)
                        folderView.clearAnimation()
                        removeUninstallIcon(folderView)
                        mDock.removeView(folderView)
                        addAppToDock(view, index)
                        makeAppWobble(view, true, index)
                    } else {
                        val gridLayout = pages[getCurrentAppsPageNumber()]
                        val index = gridLayout.indexOfChild(folderView)
                        folderView.clearAnimation()
                        removeUninstallIcon(folderView)
                        gridLayout.removeView(folderView)
                        addAppToGrid(gridLayout, view, index)
                        makeAppWobble(view, true, index)
                    }
                    DatabaseManager.getManager(this).removeLauncherItem(folder.id)
                } else {
                    updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                    folderView.applyBadge(checkHasApp(folder, mAppsWithNotifications), !folderFromDock)
                }
                if (moving.parent != null) {
                    (moving.parent as ViewGroup).removeView(moving)
                }
                val current = getCurrentAppsPageNumber()
                addAppToGrid(pages[current], moving)
                makeAppWobble(moving, true, pages[current].childCount - 1)
            }

            hideFolderWindowContainer()
            moving.visibility = VISIBLE
        }
    }

    private fun discardCollidingApp() {
        val app = collidingApp
        if (app != null) {
            makeAppCold(app, !((app.parent as View).parent is HorizontalPager))
            collidingApp = null
            folderInterest = false
        }
    }

    private fun createOrUpdateFolder(fromDock: Boolean) {
        val colliding = collidingApp ?: return
        val moving = movingApp ?: return
        colliding.clearAnimation()

        val index = if (fromDock) {
            mDock.indexOfChild(colliding)
        } else {
            getGridFromPage(pages[getCurrentAppsPageNumber()]).indexOfChild(colliding)
        }

        val app1 = getAppDetails(colliding)
        val app2 = getAppDetails(moving)

        if (app1.itemType == Constants.ITEM_TYPE_FOLDER) {
            val folderItem = app1 as FolderItem
            app2.container = folderItem.id.toLong()
            app2.screenId = -1
            app2.cell = folderItem.items!!.size
            folderItem.items!!.add(app2)
            updateIcon(colliding, app1, GraphicsUtil(this).generateFolderIcon(this, folderItem), folderFromDock)
            colliding.applyBadge(checkHasApp(folderItem, mAppsWithNotifications), !fromDock)
            makeAppWobble(colliding, true, index)
        } else {
            val folder = FolderItem()
            folder.title = getString(R.string.untitled)
            folder.id = System.currentTimeMillis().toString()
            folder.items = ArrayList()
            app1.container = folder.id.toLong()
            app2.container = folder.id.toLong()
            app1.screenId = -1
            app2.screenId = -1
            app1.cell = folder.items!!.size
            folder.items!!.add(app1)
            app2.cell = folder.items!!.size
            folder.items!!.add(app2)
            val folderIcon = GraphicsUtil(this).generateFolderIcon(this, app1.icon!!, app2.icon!!)
            folder.icon = folderIcon
            val folderView = prepareLauncherItem(folder)
            makeAppWobble(colliding, false, index)
            (colliding.parent as ViewGroup).removeView(colliding)
            if (fromDock) {
                addAppToDock(folderView, index)
            } else {
                addAppToGrid(pages[getCurrentAppsPageNumber()], folderView, index)
            }
            makeAppWobble(folderView, true, index)
        }

        if (moving.parent != null) {
            (moving.parent as ViewGroup).removeView(moving)
        }

        makeAppCold(colliding, fromDock)
        makeAppCold(moving, fromDock)
    }

    private fun updateIcon(appView: BlissFrameLayout, app: LauncherItem, drawable: Drawable?, folderFromDock: Boolean) {
        app.icon = drawable
        val tags = appView.tag as List<*>
        val iv = tags[0] as SquareImageView
        iv.setImageDrawable(drawable)
    }

    private fun makeAppHot(app: View?) {
        if (app == null) {
            return
        }
        app.scaleX = 1.2f
        app.scaleY = 1.2f
    }

    @Synchronized
    private fun makeAppCold(app: View?, fromDock: Boolean) {
        if (app == null) {
            return
        }

        val views = app.tag as List<*>
        if (!fromDock) {
            (views[1] as View).visibility = VISIBLE
        } else {
            (views[1] as View).visibility = GONE
        }
        app.scaleX = 1.0f
        app.scaleY = 1.0f
        collidingApp = null
    }

    private fun getAppDetails(app: View?): LauncherItem =
        (app as? BlissFrameLayout)?.launcherItem ?: error("Expected BlissFrameLayout")

    private fun checkIfFolderInterest(view: ViewGroup, index: Int, x: Float, y: Float): Boolean {
        val v = view.getChildAt(index).findViewById<View>(R.id.app_icon)
        val r = Rect()
        v.getGlobalVisibleRect(r)
        val vx = r.left + (r.right - r.left) / 2f
        val vy = r.top + (r.bottom - r.top) / 2f
        val distance = getDistance(x, y, vx, vy)
        return distance < maxDistanceForFolderCreation
    }

    private fun getGridFromPage(page: ViewGroup): GridLayout = page as GridLayout

    private fun getDistance(x1: Float, y1: Float, x2: Float, y2: Float): Double =
        sqrt((x2 - x1).toDouble().pow(2.0) + (y2 - y1).toDouble().pow(2.0))

    private fun getIndex(page: ViewGroup, x: Float, y: Float): Int {
        var minDistance = Float.MAX_VALUE
        var index = EMPTY_LOCATION_DRAG

        for (i in 0 until page.childCount) {
            val v = page.getChildAt(i).findViewById<View>(R.id.app_icon)
            val r = Rect()
            v.getGlobalVisibleRect(r)
            val r2 = Rect(
                (x - mDeviceProfile.iconSizePx / 2).toInt(),
                (y - mDeviceProfile.iconSizePx / 2).toInt(),
                (x + mDeviceProfile.iconSizePx / 2).toInt(),
                (y + mDeviceProfile.iconSizePx / 2).toInt()
            )
            if (Rect.intersects(r, r2)) {
                val vx = r.left + (r.right - r.left) / 2f
                val vy = r.top + (r.bottom - r.top) / 2f
                val distance = hypot(vx - x, vy - y)
                if (minDistance > distance) {
                    minDistance = distance
                    index = i
                }
            }
        }
        return index
    }

    private fun getDefaultLayoutTransition(): LayoutTransition {
        val transition = LayoutTransition()
        transition.disableTransitionType(LayoutTransition.APPEARING)
        transition.disableTransitionType(LayoutTransition.DISAPPEARING)
        transition.setStartDelay(LayoutTransition.CHANGE_APPEARING, 0)
        transition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, 0)
        transition.addTransitionListener(object : LayoutTransition.TransitionListener {
            override fun startTransition(layoutTransition: LayoutTransition, viewGroup: ViewGroup, view: View, i: Int) {
                dragDropEnabled = false
            }

            override fun endTransition(layoutTransition: LayoutTransition, viewGroup: ViewGroup, view: View, i: Int) {
                dragDropEnabled = true
            }
        })
        return transition
    }

    private fun createIndicator() {
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        indicatorWheelView = null
        showSearchControlInIndicator(false)
        updateWorkspaceChromeForPage(currentPageNumber)
    }

    private fun refreshPageIndicator() {
        if (isHomePage(currentPageNumber)) {
            if (isWobbling || indicatorMode == IndicatorMode.DOTS) {
                showDotsInIndicator(homePagePositionForPagerPage(currentPageNumber), false)
            } else {
                showSearchControlInIndicator(false)
            }
        } else {
            updateWorkspaceChromeForPage(currentPageNumber)
        }
    }

    private fun showPageIndicator(page: Int) {
        if (!isHomePage(page)) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            mIndicator.visibility = GONE
            return
        }

        if (homeIndicatorPageCount() <= 1) {
            showSearchControlInIndicator(false)
            return
        }

        showDotsInIndicator(homePagePositionForPagerPage(page), true)
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        mSearchPill?.visibility = GONE
        if (!isWobbling) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun hidePageIndicator() {
        if (isWobbling) {
            return
        }
        showSearchControlInIndicator(true)
    }

    private fun updatePageIndicatorDots(selectedPosition: Int) {
        if (indicatorMode != IndicatorMode.DOTS && !isWobbling) {
            return
        }

        val pageCount = homeIndicatorPageCount()
        if (pageCount <= 1) {
            return
        }

        val selectedPage = max(0, min(selectedPosition, pageCount - 1))
        ensureIndicatorWheelView().setMarkers(
            LauncherPageIndicatorWindowPolicy.markers(
                pageCount,
                selectedPage,
                LauncherPageIndicatorWindowPolicy.DEFAULT_MAX_VISIBLE_MARKERS
            ),
            false
        )
    }

    private fun showDotsInIndicator(position: Int, animate: Boolean) {
        showDotsIndicatorFrame()
        updatePageIndicatorDots(position)
        if (animate) {
            mIndicator.animate()
                .alpha(1f)
                .setDuration(120L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
    }

    private fun updatePageIndicatorScroll(scrollX: Int) {
        if (pages.isEmpty()) {
            return
        }
        val pageWidth = max(1, mHorizontalPager.getPageWidth())
        val pagerPosition = scrollX / pageWidth.toFloat()
        val fromPage = floor(pagerPosition).toInt()
        if (!isHomePage(fromPage) && !isHomePage(fromPage + 1)) {
            return
        }

        val pageCount = homeIndicatorPageCount()
        if (pageCount <= 1) {
            return
        }

        val homePagePosition = max(0f, min(pagerPosition - 1f, pageCount - 1f))
        showDotsIndicatorFrame()
        ensureIndicatorWheelView().setScrollPosition(pageCount, homePagePosition)
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        if (!isWobbling) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun showDotsIndicatorFrame() {
        indicatorMode = IndicatorMode.DOTS
        ensureDotsIndicatorFrame()
        ensureIndicatorWheelView()
        mSearchPill?.animate()?.cancel()
        mSearchPill?.visibility = GONE
        if (homeIndicatorPageCount() <= 1) {
            mIndicator.removeAllViews()
            mIndicator.visibility = GONE
            return
        }
        mIndicator.animate().cancel()
        mIndicator.isClickable = false
        mIndicator.alpha = 1f
        mIndicator.visibility = VISIBLE
    }

    private fun showSearchControlInIndicator(animated: Boolean) {
        if (!isHomePage(currentPageNumber) || isWobbling) {
            return
        }

        indicatorMode = IndicatorMode.SEARCH
        ensureSearchIndicatorFrame()
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        mSearchPill?.animate()?.cancel()
        mSearchPill?.visibility = GONE
        mIndicator.animate().cancel()
        mIndicator.isClickable = true
        mIndicator.alpha = 1f
        mIndicator.visibility = VISIBLE
        mIndicator.removeAllViews()
        mIndicator.addView(createIndicatorSearchText())
        if (animated) {
            val child = mIndicator.getChildAt(0)
            if (child != null) {
                child.alpha = 0f
                child.animate()
                    .alpha(1f)
                    .setDuration(150L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }
        }
    }

    private fun createIndicatorSearchText(): TextView {
        val searchText = TextView(this)
        searchText.text = getString(R.string.launcher_search_hint)
        searchText.gravity = Gravity.CENTER
        searchText.includeFontPadding = false
        searchText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search_18, 0, 0, 0)
        searchText.compoundDrawablePadding = dp(4)
        searchText.setTextColor(Color.WHITE)
        searchText.textSize = 12f
        searchText.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return searchText
    }

    private fun ensureDotsIndicatorFrame() {
        val layoutParams = mIndicator.layoutParams
        layoutParams.width = dp(PAGE_INDICATOR_SEARCH_WIDTH_DP)
        layoutParams.height = dp(PAGE_INDICATOR_SEARCH_HEIGHT_DP)
        mIndicator.layoutParams = layoutParams
        mIndicator.setPadding(dp(PAGE_INDICATOR_DOT_PADDING_DP), 0, dp(PAGE_INDICATOR_DOT_PADDING_DP), 0)
        mIndicator.layoutTransition = null
    }

    private fun ensureIndicatorWheelView(): LauncherPageIndicatorWheelView {
        val existing = indicatorWheelView
        if (existing != null && existing.parent === mIndicator) {
            return existing
        }

        val wheelView = LauncherPageIndicatorWheelView(this)
        wheelView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        mIndicator.removeAllViews()
        mIndicator.addView(wheelView)
        indicatorWheelView = wheelView
        return wheelView
    }

    private fun ensureSearchIndicatorFrame() {
        val layoutParams = mIndicator.layoutParams
        layoutParams.width = dp(PAGE_INDICATOR_SEARCH_WIDTH_DP)
        layoutParams.height = dp(PAGE_INDICATOR_SEARCH_HEIGHT_DP)
        mIndicator.layoutParams = layoutParams
        mIndicator.setPadding(dp(10), 0, dp(10), 0)
        indicatorWheelView = null
    }

    private fun homeIndicatorPageCount(): Int = pages.size

    private fun updateWorkspaceChromeForPage(page: Int) {
        val edgePage = isWidgetPage(page) || isLibraryPage(page)
        mBottomControlSlot?.visibility = if (edgePage) GONE else VISIBLE
        mDock.visibility = if (edgePage) GONE else VISIBLE
        if (edgePage) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            mIndicator.visibility = GONE
            mSearchPill?.visibility = GONE
        } else if (isWobbling) {
            mSearchPill?.visibility = GONE
            showDotsInIndicator(homePagePositionForPagerPage(page), false)
            mIndicator.visibility = VISIBLE
        } else if (indicatorMode == IndicatorMode.SEARCH) {
            showSearchControlInIndicator(false)
        }
    }

    private fun isWidgetPage(page: Int): Boolean = page == WIDGET_PAGE

    private fun isLibraryPage(page: Int): Boolean = page == pages.size + 1

    private fun isHomePage(page: Int): Boolean = page >= 1 && page <= pages.size

    private fun homePagePositionForPagerPage(page: Int): Int {
        val lastPage = max(0, homeIndicatorPageCount() - 1)
        return max(0, min(page - 1, lastPage))
    }

    override fun onBackPressed() {
        returnToHomeScreen()
    }

    private fun displayFolder(app: FolderItem, v: BlissFrameLayout) {
        currentAnimator?.cancel()

        activeFolder = app
        activeFolderView = v

        startBounds = Rect()
        finalBounds = Rect()
        val globalOffset = Point()

        v.getGlobalVisibleRect(startBounds)
        findViewById<View>(R.id.workspace).getGlobalVisibleRect(finalBounds, globalOffset)
        startBounds.offset(-globalOffset.x, -globalOffset.y)
        finalBounds.offset(-globalOffset.x, -globalOffset.y)

        val startScale: Float
        if (finalBounds.width().toFloat() / finalBounds.height() >
            startBounds.width().toFloat() / startBounds.height()
        ) {
            startScale = startBounds.height().toFloat() / finalBounds.height()
            val startWidth = startScale * finalBounds.width()
            val deltaWidth = ((startWidth - startBounds.width()) / 2).toInt()
            startBounds.left -= deltaWidth
            startBounds.right += deltaWidth
        } else {
            startScale = startBounds.width().toFloat() / finalBounds.width()
            val startHeight = startScale * finalBounds.height()
            val deltaHeight = ((startHeight - startBounds.height()) / 2).toInt()
            startBounds.top -= deltaHeight
            startBounds.bottom += deltaHeight
        }

        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(mFolderWindowContainer, View.X, startBounds.left.toFloat(), finalBounds.left.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.Y, startBounds.top.toFloat(), finalBounds.top.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_X, startScale, 1f))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_Y, startScale, 1f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 0f))
        set.duration = 300
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                mFolderWindowContainer.visibility = VISIBLE
                mFolderWindowContainer.pivotX = 0f
                mFolderWindowContainer.pivotY = 0f
            }

            override fun onAnimationEnd(animation: Animator) {
                currentAnimator = null
                blurLayer.alpha = 1f
                mHorizontalPager.alpha = 0f
                mIndicator.alpha = 0f
                mDock.alpha = 0f
            }

            override fun onAnimationCancel(animation: Animator) {
                currentAnimator = null
                mFolderWindowContainer.visibility = GONE
                blurLayer.alpha = 0f
                mHorizontalPager.alpha = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
            }
        })
        set.start()
        currentAnimator = set
        startScaleFinal = startScale

        mFolderTitleInput.setText(app.title)
        mFolderTitleInput.isCursorVisible = false

        mFolderAppsViewPager.adapter = FolderAppsPagerAdapter(this, app.items!!)
        mFolderAppsViewPager.layoutParams.width = mDeviceProfile.cellWidthPx * 3 +
            mDeviceProfile.iconDrawablePaddingPx
        mFolderAppsViewPager.layoutParams.height = mDeviceProfile.cellHeightPx * 3 +
            mDeviceProfile.iconDrawablePaddingPx
        (mLauncherView.findViewById<View>(R.id.indicator) as CircleIndicator).setViewPager(mFolderAppsViewPager)
    }

    private fun getLauncherView(): Bitmap {
        val view = window.decorView.rootView
        view.isDrawingCacheEnabled = true
        view.buildDrawingCache(true)
        val bitmap = Bitmap.createBitmap(view.drawingCache)
        view.isDrawingCacheEnabled = false
        return bitmap
    }

    private fun hideFolderWindowContainer() {
        DatabaseManager.getManager(this@LauncherActivity).saveLayouts(pages, mDock)
        mFolderTitleInput.clearFocus()
        folderFromDock = false
        currentAnimator?.cancel()

        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(mFolderWindowContainer, View.X, startBounds.left.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.Y, startBounds.top.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_X, startScaleFinal))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_Y, startScaleFinal))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 1f))
        set.duration = 300
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                mHorizontalPager.visibility = VISIBLE
                mDock.visibility = VISIBLE
                mIndicator.visibility = VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                mFolderWindowContainer.visibility = GONE
                currentAnimator = null
                blurLayer.alpha = 0f
                mHorizontalPager.alpha = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
            }

            override fun onAnimationCancel(animation: Animator) {
                mFolderWindowContainer.visibility = GONE
                currentAnimator = null
                blurLayer.alpha = 0f
                mHorizontalPager.alpha = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
            }
        })
        set.start()
        currentAnimator = set
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val alreadyOnHome = hasWindowFocus() &&
            intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT

        val shouldMoveToDefaultScreen = alreadyOnHome &&
            swipeSearchContainer.visibility != VISIBLE &&
            !isWobbling &&
            mFolderWindowContainer.visibility != VISIBLE &&
            (activeRoundedWidgetView == null || activeRoundedWidgetView?.isWidgetActivated() != true)

        if (alreadyOnHome) {
            returnToHomeScreen()
        }

        if (shouldMoveToDefaultScreen) {
            mHorizontalPager.visibility = VISIBLE
            mHorizontalPager.alpha = 1f
            mDock.visibility = VISIBLE
            mDock.alpha = 1f
            mIndicator.visibility = VISIBLE
            mIndicator.alpha = 1f
            mHorizontalPager.snapToPage(1)
        }
    }

    private fun returnToHomeScreen() {
        if (activeRoundedWidgetView != null && activeRoundedWidgetView?.isWidgetActivated() == true) {
            hideWidgetResizeContainer()
        }

        mSearchInput?.setText("")

        if (swipeSearchContainer.visibility == VISIBLE) {
            hideSwipeSearchContainer()
        }

        if (isWobbling) {
            handleWobbling(false)
        } else if (mFolderWindowContainer.visibility == VISIBLE) {
            hideFolderWindowContainer()
        }
    }

    private fun showSwipeSearchContainer() {
        currentAnimator?.cancel()
        val animationDuration = (blurLayer.alpha * 300).toInt()
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(swipeSearchContainer, View.TRANSLATION_Y, 0f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 0f))
        set.duration = animationDuration.toLong()
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationCancel(animation: Animator) {
                super.onAnimationCancel(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = GONE
                blurLayer.alpha = 0f
                mHorizontalPager.visibility = VISIBLE
                mDock.visibility = VISIBLE
                mIndicator.visibility = VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                currentAnimator = null

                blurLayer.alpha = 1f
                mHorizontalPager.visibility = GONE
                mDock.visibility = GONE
                mIndicator.visibility = GONE

                val searchEditText = swipeSearchContainer.findViewById<BlissInput>(R.id.search_input)
                val clearSuggestions = swipeSearchContainer.findViewById<ImageView>(R.id.clearSuggestionImageView)
                searchDisposableObserver = searchEditText.textChanges()
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .map { it.toString() }
                    .distinctUntilChanged()
                    .switchMap { charSequence ->
                        if (charSequence.isNotEmpty()) {
                            this@LauncherActivity.runOnUiThread { clearSuggestions.visibility = VISIBLE }
                            this@LauncherActivity.searchForQuery(charSequence)
                        } else {
                            this@LauncherActivity.runOnUiThread { clearSuggestions.visibility = GONE }
                            Observable.just(SuggestionsResult(charSequence))
                        }
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(
                        SearchInputDisposableObserver(
                            this@LauncherActivity,
                            swipeSearchContainer.findViewById<RecyclerView>(R.id.suggestionRecyclerView).adapter!!,
                            swipeSearchContainer
                        )
                    )
                searchEditText.requestFocus()
                refreshSuggestedApps(swipeSearchContainer, true)
            }
        })
        set.start()
        currentAnimator = set
    }

    private fun setUpSwipeSearchContainer() {
        val searchEditText = swipeSearchContainer.findViewById<BlissInput>(R.id.search_input)
        mSearchInput = searchEditText
        val clearSuggestions = swipeSearchContainer.findViewById<ImageView>(R.id.clearSuggestionImageView)
        clearSuggestions.setOnClickListener {
            searchEditText.setText("")
            searchEditText.clearFocus()
        }

        val suggestionRecyclerView = swipeSearchContainer.findViewById<RecyclerView>(R.id.suggestionRecyclerView)
        val networkSuggestionAdapter = AutoCompleteAdapter(this)
        suggestionRecyclerView.adapter = networkSuggestionAdapter
        suggestionRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        searchEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            } else {
                showKeyboard(v)
            }
        }
        searchEditText.clearFocus()

        searchEditText.setOnEditorActionListener { _, action, _ ->
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard(searchEditText)
                runSearch(searchEditText.text.toString())
                searchEditText.setText("")
                searchEditText.clearFocus()
                true
            } else {
                false
            }
        }
    }

    private fun hideSwipeSearchContainer() {
        currentAnimator?.cancel()
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(swipeSearchContainer, View.TRANSLATION_Y, -swipeSearchContainer.height.toFloat()))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 0f))
        set.duration = 300
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                mHorizontalPager.visibility = VISIBLE
                mDock.visibility = VISIBLE
                mIndicator.visibility = VISIBLE
            }

            override fun onAnimationCancel(animation: Animator) {
                super.onAnimationCancel(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = VISIBLE
                blurLayer.alpha = 1f
                mHorizontalPager.visibility = GONE
                mDock.visibility = GONE
                mIndicator.visibility = GONE
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = GONE
                blurLayer.alpha = 0f
                if (searchDisposableObserver != null && searchDisposableObserver?.isDisposed == false) {
                    searchDisposableObserver?.dispose()
                }
                swipeSearchContainer.findViewById<BlissInput>(R.id.search_input).setText("")
                swipeSearchContainer.findViewById<View>(R.id.search_input).clearFocus()
            }
        })
        set.start()
        currentAnimator = set
    }

    override fun onSwipeStart() {
        swipeSearchContainer.translationY = BlissLauncher.getApplication(this).deviceProfile.availableHeightPx.toFloat()
        swipeSearchContainer.visibility = GONE
        showSwipeSearch = false
    }

    override fun onSwipe(position: Int) {
        if ((longPressed && !mLongClickStartsDrag) || (!longPressed && isWobbling)) {
            return
        }
        swipeSearchContainer.visibility = VISIBLE
        val translateBy = position * 1.25f
        if (translateBy <= swipeSearchContainer.height) {
            swipeSearchContainer.translationY = -swipeSearchContainer.height + translateBy
            val deltaAlpha = 1f - translateBy / swipeSearchContainer.height
            mHorizontalPager.alpha = deltaAlpha
            mIndicator.alpha = deltaAlpha
            mDock.alpha = deltaAlpha
            blurLayer.alpha = 1 - deltaAlpha
        }

        showSwipeSearch = translateBy >= swipeSearchContainer.height / 2
    }

    override fun onSwipeFinish() {
        if (showSwipeSearch) {
            showSwipeSearchContainer()
        } else {
            hideSwipeSearchContainer()
        }
    }

    fun showWidgetResizeContainer(roundedWidgetView: RoundedWidgetView) {
        val page = widgetsPage ?: return
        val widgetResizeContainer = page.findViewById<RelativeLayout>(R.id.widget_resizer_container)
        if (widgetResizeContainer.visibility != VISIBLE) {
            activeRoundedWidgetView = roundedWidgetView

            val seekBar = widgetResizeContainer.findViewById<SeekBar>(R.id.widget_resizer_seekbar)
            currentAnimator?.cancel()

            seekBar.setOnTouchListener { v, _ ->
                v.parent.requestDisallowInterceptTouchEvent(true)
                false
            }

            val set = AnimatorSet()
            set.play(ObjectAnimator.ofFloat(widgetResizeContainer, View.TRANSLATION_Y, Utilities.pxFromDp(48, this), 0f))
            set.duration = 200
            set.interpolator = LinearInterpolator()
            set.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    super.onAnimationStart(animation)
                    widgetResizeContainer.visibility = VISIBLE
                }

                override fun onAnimationCancel(animation: Animator) {
                    super.onAnimationCancel(animation)
                    currentAnimator = null
                    widgetResizeContainer.visibility = GONE
                    roundedWidgetView.removeBorder()
                }

                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    currentAnimator = null
                    prepareWidgetResizeSeekBar(seekBar)
                    roundedWidgetView.addBorder()
                }
            })
            set.start()
            currentAnimator = set
        }
    }

    private fun prepareWidgetResizeSeekBar(seekBar: SeekBar) {
        val activeView = activeRoundedWidgetView ?: return
        val minHeight = activeView.appWidgetInfo.minResizeHeight
        val maxHeight = mDeviceProfile.availableHeightPx * 3 / 4
        val normalisedDifference = (maxHeight - minHeight) / 100
        val defaultHeight = activeView.height
        val currentProgress = (defaultHeight - minHeight) * 100 / (maxHeight - minHeight)

        seekBar.max = 100
        seekBar.progress = currentProgress
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val widgetView = activeRoundedWidgetView ?: return
                val newHeight = minHeight + normalisedDifference * progress
                val layoutParams = widgetView.layoutParams as LinearLayout.LayoutParams
                layoutParams.height = newHeight
                widgetView.layoutParams = layoutParams

                val newOps = Bundle()
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH, mDeviceProfile.maxWidgetWidth)
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH, mDeviceProfile.maxWidgetWidth)
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT, newHeight)
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT, newHeight)
                widgetView.updateAppWidgetOptions(newOps)
                widgetView.requestLayout()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val widgetView = activeRoundedWidgetView ?: return
                DatabaseManager.getManager(this@LauncherActivity)
                    .saveWidgetHeight(widgetView.appWidgetId, seekBar.progress)
            }
        })
    }

    fun hideWidgetResizeContainer() {
        val page = widgetsPage ?: return
        val widgetResizeContainer = page.findViewById<RelativeLayout>(R.id.widget_resizer_container)
        if (widgetResizeContainer.visibility == VISIBLE) {
            currentAnimator?.cancel()
            val set = AnimatorSet()
            set.play(ObjectAnimator.ofFloat(widgetResizeContainer, View.TRANSLATION_Y, Utilities.pxFromDp(48, this)))
            set.duration = 200
            set.interpolator = LinearInterpolator()
            set.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    super.onAnimationStart(animation)
                    page.findViewById<SeekBar>(R.id.widget_resizer_seekbar).setOnSeekBarChangeListener(null)
                }

                override fun onAnimationCancel(animation: Animator) {
                    super.onAnimationCancel(animation)
                    currentAnimator = null
                    widgetResizeContainer.visibility = VISIBLE
                }

                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    currentAnimator = null
                    widgetResizeContainer.visibility = GONE
                    activeRoundedWidgetView?.removeBorder()
                }
            })
            set.start()
            currentAnimator = set
        }
    }

    fun forceReload() {
        if (mFolderWindowContainer.visibility == VISIBLE) {
            returnToHomeScreen()
        }

        allAppsDisplayed = false
        BlissLauncher.getApplication(this).appProvider.getAppsRepository()
            .updateAppsRelay(emptyList())
    }

    override fun onColorsChanged() {
        updateTheme()
    }

    private fun updateTheme() {
        if (mThemeRes != getActivityThemeRes(this)) {
            recreate()
        }
    }

    inner class FolderAppsPagerAdapter(
        private val mContext: Context,
        private val mFolderAppItems: List<LauncherItem>
    ) : PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val viewGroup = LayoutInflater.from(mContext).inflate(R.layout.apps_page, container, false) as GridLayout
            viewGroup.rowCount = 3
            viewGroup.columnCount = 3
            viewGroup.setPadding(
                mDeviceProfile.iconDrawablePaddingPx / 2,
                mDeviceProfile.iconDrawablePaddingPx / 2,
                mDeviceProfile.iconDrawablePaddingPx / 2,
                mDeviceProfile.iconDrawablePaddingPx / 2
            )
            var i = 0
            while (9 * position + i < mFolderAppItems.size && i < 9) {
                val appItem = mFolderAppItems[9 * position + i]
                val appView = prepareLauncherItem(appItem)
                val iconLayoutParams = GridLayout.LayoutParams()
                iconLayoutParams.height = mDeviceProfile.cellHeightPx
                iconLayoutParams.width = mDeviceProfile.cellWidthPx
                appView.findViewById<View>(R.id.app_label).visibility = VISIBLE
                appView.layoutParams = iconLayoutParams
                viewGroup.addView(appView)
                i++
            }
            container.addView(viewGroup)
            return viewGroup
        }

        override fun getCount(): Int = ceil(mFolderAppItems.size.toFloat() / 9).toInt()

        override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }

    inner class ReorderAlarmListener(
        private val mPage: GridLayout,
        private val mParent: ViewGroup,
        private val mIndex: Int
    ) : Alarm.OnAlarmListener {
        override fun onAlarm(alarm: Alarm) {
            val moving = movingApp ?: return
            val gridLayout = pages[getCurrentAppsPageNumber()]
            if (moving.parent != null &&
                (parentPage == getCurrentAppsPageNumber() || gridLayout.childCount < mDeviceProfile.maxAppsPerPage)
            ) {
                (moving.parent as ViewGroup).removeView(moving)
                if (gridLayout.childCount < mDeviceProfile.maxAppsPerPage) {
                    addAppToGrid(gridLayout, moving, mIndex)
                    parentPage = getCurrentAppsPageNumber()
                }
            }
        }
    }

    inner class DockReorderAlarmListener(private val mIndex: Int) : Alarm.OnAlarmListener {
        override fun onAlarm(alarm: Alarm) {
            val moving = movingApp ?: return
            if (mDock.childCount < mDeviceProfile.numColumns || parentPage == -99) {
                if (moving.parent != null) {
                    (moving.parent as ViewGroup).removeView(moving)
                }
                parentPage = -99
                addAppToDock(moving, mIndex)
            }
        }
    }
}
