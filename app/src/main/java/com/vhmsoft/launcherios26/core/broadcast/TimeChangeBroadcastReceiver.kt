package com.vhmsoft.launcherios26.core.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.vhmsoft.launcherios26.core.events.EventRelay
import com.vhmsoft.launcherios26.core.events.TimeChangedEvent

class TimeChangeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action != null &&
            (
                action.equals(Intent.ACTION_TIME_CHANGED, ignoreCase = true) ||
                    action.equals(Intent.ACTION_DATE_CHANGED, ignoreCase = true) ||
                    action.equals(Intent.ACTION_TIMEZONE_CHANGED, ignoreCase = true)
                )
        ) {
            EventRelay.getInstance().push(TimeChangedEvent())
        }
    }

    companion object {
        @JvmStatic
        fun register(context: Context): TimeChangeBroadcastReceiver {
            val timeIntentFilter = IntentFilter(Intent.ACTION_TIME_CHANGED)
            timeIntentFilter.addAction(Intent.ACTION_DATE_CHANGED)
            timeIntentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED)
            val receiver = TimeChangeBroadcastReceiver()
            context.registerReceiver(receiver, timeIntentFilter)
            return receiver
        }

        @JvmStatic
        fun unregister(context: Context, receiver: TimeChangeBroadcastReceiver) {
            context.unregisterReceiver(receiver)
        }
    }
}
