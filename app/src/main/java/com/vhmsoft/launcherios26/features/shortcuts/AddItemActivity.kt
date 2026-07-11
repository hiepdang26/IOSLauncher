package com.vhmsoft.launcherios26.features.shortcuts

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.LauncherApps
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

@TargetApi(Build.VERSION_CODES.O)
class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentIntent = intent
        if (currentIntent?.action?.equals(
                LauncherApps.ACTION_CONFIRM_PIN_SHORTCUT,
                ignoreCase = true
            ) == true
        ) {
            val launcherApps = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
            val request = launcherApps.getPinItemRequest(currentIntent)
            if (request == null) {
                finish()
                return
            }

            if (request.requestType == LauncherApps.PinItemRequest.REQUEST_TYPE_SHORTCUT) {
                InstallShortcutReceiver.queueShortcut(
                    ShortcutInfoCompat(request.shortcutInfo),
                    applicationContext
                )
                request.accept()
                finish()
            }
        }
    }
}
