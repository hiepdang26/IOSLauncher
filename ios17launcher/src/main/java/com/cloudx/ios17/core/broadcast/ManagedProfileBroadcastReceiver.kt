package com.cloudx.ios17.core.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.UserHandle
import com.cloudx.ios17.core.events.EventRelay
import com.cloudx.ios17.core.events.ForceReloadEvent
import timber.log.Timber

class ManagedProfileBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Timber.tag("PROFILE").i("onReceive: ${intent.action}")
        val action = intent.action
        if (Intent.ACTION_MANAGED_PROFILE_ADDED == action ||
            Intent.ACTION_MANAGED_PROFILE_REMOVED == action
        ) {
            EventRelay.getInstance().push(ForceReloadEvent())
        } else if (
            Intent.ACTION_MANAGED_PROFILE_AVAILABLE == action ||
            Intent.ACTION_MANAGED_PROFILE_UNAVAILABLE == action ||
            Intent.ACTION_MANAGED_PROFILE_UNLOCKED == action
        ) {
            val user = intent.getParcelableExtra<UserHandle>(Intent.EXTRA_USER)
            if (user != null) {
                EventRelay.getInstance().push(ForceReloadEvent())
            }
        }
    }

    companion object {
        @JvmStatic
        fun register(context: Context): ManagedProfileBroadcastReceiver {
            val timeIntentFilter = IntentFilter(Intent.ACTION_MANAGED_PROFILE_ADDED)
            timeIntentFilter.addAction(Intent.ACTION_MANAGED_PROFILE_REMOVED)
            timeIntentFilter.addAction(Intent.ACTION_MANAGED_PROFILE_AVAILABLE)
            timeIntentFilter.addAction(Intent.ACTION_MANAGED_PROFILE_UNAVAILABLE)
            timeIntentFilter.addAction(Intent.ACTION_MANAGED_PROFILE_UNLOCKED)
            val receiver = ManagedProfileBroadcastReceiver()
            context.registerReceiver(receiver, timeIntentFilter)
            return receiver
        }

        @JvmStatic
        fun unregister(context: Context, receiver: ManagedProfileBroadcastReceiver) {
            context.unregisterReceiver(receiver)
        }
    }
}
