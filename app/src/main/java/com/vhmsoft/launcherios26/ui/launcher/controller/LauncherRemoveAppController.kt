package com.vhmsoft.launcherios26.ui.launcher.controller

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.data.model.LauncherApp

class LauncherRemoveAppController(
    private val activity: AppCompatActivity,
    private val showError: (String) -> Unit,
    private val launchUninstall: (Intent, LauncherApp) -> Unit
) {
    fun showRemoveAppDialog(app: LauncherApp) {
        if (!app.canUninstall) {
            showError(activity.getString(R.string.launcher_uninstall_failed))
            return
        }
        requestUninstall(app)
    }

    private fun requestUninstall(app: LauncherApp) {
        val packageUri = Uri.fromParts("package", app.packageName, null)
        val uninstallIntent = Intent(Intent.ACTION_DELETE, packageUri).apply {
            putExtra(Intent.EXTRA_RETURN_RESULT, true)
        }
        launchUninstall(uninstallIntent, app)
    }
}
