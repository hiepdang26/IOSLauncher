package com.cloudx.ios17.core.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Process
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.core.events.AppAddEvent
import com.cloudx.ios17.core.events.AppChangeEvent
import com.cloudx.ios17.core.events.AppRemoveEvent
import com.cloudx.ios17.core.events.EventRelay
import com.cloudx.ios17.core.utils.UserHandle
import timber.log.Timber

class PackageAddedRemovedHandler : BroadcastReceiver() {

    override fun onReceive(ctx: Context, intent: Intent) {
        val packageName = intent.data?.schemeSpecificPart ?: return
        if (packageName.equals(ctx.packageName, ignoreCase = true)) {
            return
        }
        handleEvent(
            ctx,
            intent.action,
            packageName,
            UserHandle(),
            intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)
        )
    }

    companion object {
        private const val TAG = "PackageAddedRemovedHand"

        @JvmStatic
        fun handleEvent(
            ctx: Context,
            action: String?,
            packageName: String?,
            user: UserHandle,
            replacing: Boolean
        ) {
            if (Process.myUserHandle() != user.getRealHandle()) {
                return
            }
            Timber.tag(TAG).d(
                "handleEvent() called with: ctx = [$ctx], action = [$action], packageName = [$packageName], user = [$user], replacing = [$replacing]"
            )

            if (Intent.ACTION_PACKAGE_ADDED == action && !replacing) {
                if (packageName == null) {
                    return
                }
                val launchIntent = ctx.packageManager.getLaunchIntentForPackage(packageName) ?: return

                BlissLauncher.getApplication(ctx).resetIconsHandler()

                EventRelay.getInstance().push(AppAddEvent(packageName, user))
                BlissLauncher.getApplication(ctx).appProvider.reload(false)
            }

            if (Intent.ACTION_PACKAGE_CHANGED.equals(action, ignoreCase = true)) {
                if (packageName == null) {
                    return
                }
                val launchIntent = ctx.packageManager.getLaunchIntentForPackage(packageName)
                if (launchIntent != null) {
                    BlissLauncher.getApplication(ctx).iconsHandler
                        .resetIconDrawableForPackage(launchIntent.component, user)
                }

                BlissLauncher.getApplication(ctx).resetIconsHandler()

                EventRelay.getInstance().push(AppChangeEvent(packageName, user))
                BlissLauncher.getApplication(ctx).appProvider.reload(false)
            }

            if (Intent.ACTION_PACKAGE_REMOVED == action && !replacing) {
                if (packageName == null) {
                    return
                }
                EventRelay.getInstance().push(AppRemoveEvent(packageName, user))
                BlissLauncher.getApplication(ctx).appProvider.reload(false)
            }

            if (Intent.ACTION_MEDIA_MOUNTED == action) {
                if (packageName == null) {
                    return
                }
                val launchIntent = ctx.packageManager.getLaunchIntentForPackage(packageName)
                if (launchIntent != null) {
                    BlissLauncher.getApplication(ctx).iconsHandler
                        .resetIconDrawableForPackage(launchIntent.component, user)
                    EventRelay.getInstance().push(AppChangeEvent(packageName, user))
                }
            }
        }
    }
}
