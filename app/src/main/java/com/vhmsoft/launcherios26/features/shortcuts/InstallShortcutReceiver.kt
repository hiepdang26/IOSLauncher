package com.vhmsoft.launcherios26.features.shortcuts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Parcelable
import android.os.UserManager
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.core.IconsHandler
import com.vhmsoft.launcherios26.core.Utilities
import com.vhmsoft.launcherios26.core.database.model.ShortcutItem
import com.vhmsoft.launcherios26.core.events.EventRelay
import com.vhmsoft.launcherios26.core.events.ShortcutAddEvent
import com.vhmsoft.launcherios26.core.utils.Constants
import com.vhmsoft.launcherios26.core.utils.UserHandle
import java.io.ByteArrayOutputStream
import timber.log.Timber

class InstallShortcutReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, data: Intent) {
        if (ACTION_INSTALL_SHORTCUT != data.action) {
            return
        }
        val shortcutItem = createShortcutItem(data, context) ?: return
        EventRelay.getInstance().push(ShortcutAddEvent(shortcutItem))
    }

    companion object {
        private const val TAG = "InstallShortcutReceiver"

        private const val ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT"

        private const val LAUNCH_INTENT_KEY = "intent.launch"
        private const val DEEPSHORTCUT_TYPE_KEY = "isDeepShortcut"
        private const val APP_SHORTCUT_TYPE_KEY = "isAppShortcut"
        private const val USER_HANDLE_KEY = "userHandle"
        private const val NAME_KEY = "name"
        private const val ICON_KEY = "icon"
        private const val ICON_RESOURCE_NAME_KEY = "iconResource"
        private const val ICON_RESOURCE_PACKAGE_NAME_KEY = "iconResourcePackage"

        private const val APPS_PENDING_INSTALL = "apps_to_install"

        const val NEW_SHORTCUT_BOUNCE_DURATION = 450
        const val NEW_SHORTCUT_STAGGER_DELAY = 85

        private val sLock = Any()

        @JvmStatic
        fun queueShortcut(info: ShortcutInfoCompat, context: Context) {
            Timber.tag(TAG).d("queueShortcut() called with: info = [$info], context = [$context]")
            val userManager = context.getSystemService(Context.USER_SERVICE) as UserManager
            val shortcutItem = ShortcutItem()
            shortcutItem.id = info.id
            Timber.tag(TAG).i("queueShortcut: ${shortcutItem.id}")
            shortcutItem.user = UserHandle(
                userManager.getSerialNumberForUser(info.userHandle),
                info.userHandle
            )
            shortcutItem.packageName = info.`package`
            shortcutItem.title = info.shortLabel?.toString()
            shortcutItem.container = Constants.CONTAINER_DESKTOP.toLong()
            val icon = DeepShortcutManager.getInstance(context).getShortcutIconDrawable(
                info,
                context.resources.displayMetrics.densityDpi
            )
            shortcutItem.icon = BlissLauncher.getApplication(context).iconsHandler.convertIcon(icon)
            shortcutItem.launchIntent = info.makeIntent()
            EventRelay.getInstance().push(ShortcutAddEvent(shortcutItem))
        }

        private fun createShortcutItem(data: Intent, context: Context): ShortcutItem? {
            val intent = data.getParcelableExtra<Intent>(Intent.EXTRA_SHORTCUT_INTENT)
            val name = data.getStringExtra(Intent.EXTRA_SHORTCUT_NAME)
            val bitmap = data.getParcelableExtra<Parcelable>(Intent.EXTRA_SHORTCUT_ICON)

            if (intent == null) {
                Timber.tag(TAG).e("Can't construct ShortcutInfo with null intent")
                return null
            }

            val item = ShortcutItem()
            item.user = UserHandle()

            var icon: Drawable? = null
            if (bitmap is Bitmap) {
                icon = IconsHandler.createIconDrawable(bitmap, context)
            } else {
                val extra = data.getParcelableExtra<Parcelable>(Intent.EXTRA_SHORTCUT_ICON_RESOURCE)
                if (extra is Intent.ShortcutIconResource) {
                    icon = IconsHandler.createIconDrawable(extra, context)
                }
            }
            if (icon == null) {
                icon = BlissLauncher.getApplication(context).iconsHandler.fullResDefaultActivityIcon
            }
            item.packageName = intent.`package`
            item.container = Constants.CONTAINER_DESKTOP.toLong()
            item.title = Utilities.trim(name)
            item.icon = BlissLauncher.getApplication(context).iconsHandler.convertIcon(icon)
            val itemIcon = item.icon
            if (itemIcon != null) {
                val baos = ByteArrayOutputStream()
                convertToBitmap(itemIcon).compress(Bitmap.CompressFormat.PNG, 100, baos)
                item.icon_blob = baos.toByteArray()
            }
            item.launchIntent = intent
            item.launchIntentUri = item.launchIntent?.toUri(0)
            item.id = item.packageName + "/" + item.launchIntentUri
            return item
        }

        private fun convertToBitmap(drawable: Drawable): Bitmap {
            val bitmap = Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
            drawable.draw(canvas)

            return bitmap
        }
    }
}
