package com.vhmsoft.launcherios26.features.shortcuts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.vhmsoft.launcherios26.core.database.DatabaseManager

class UninstallShortcutReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, data: Intent) {
        val name = data.getStringExtra(Intent.EXTRA_SHORTCUT_NAME)
        if (name != null) {
            DatabaseManager.getManager(context).removeShortcut(name)
        }
    }
}
