package com.vhmsoft.launcherios26.ui.launcher.controller

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.provider.Settings
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.data.model.LauncherApp

class LauncherRemoveAppController(
    private val activity: AppCompatActivity,
    private val showError: (String) -> Unit
) {
    fun showRemoveAppDialog(app: LauncherApp) {
        val dialog = Dialog(activity)
        val content = android.widget.LinearLayout(activity).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            setPadding(dp(24), dp(22), dp(24), dp(16))
            background = activity.getDrawable(R.drawable.bg_remove_app_dialog)
        }
        val title = android.widget.TextView(activity).apply {
            text = app.label
            setTextColor(Color.BLACK)
            textSize = 20f
            setTypeface(typeface, android.graphics.Typeface.BOLD)
        }
        val message = android.widget.TextView(activity).apply {
            text = "Bạn có muốn gỡ cài đặt ứng dụng này không?"
            setTextColor(Color.rgb(34, 48, 56))
            textSize = 14f
            setPadding(0, dp(14), 0, dp(24))
        }
        val actions = android.widget.LinearLayout(activity).apply {
            gravity = Gravity.END
            orientation = android.widget.LinearLayout.HORIZONTAL
        }
        val cancel = android.widget.TextView(activity).apply {
            text = "HỦY"
            setTextColor(Color.rgb(0, 96, 128))
            textSize = 14f
            gravity = Gravity.CENTER
            setPadding(dp(20), dp(12), dp(20), dp(12))
            setOnClickListener { dialog.dismiss() }
        }
        val ok = android.widget.TextView(activity).apply {
            text = "OK"
            setTextColor(Color.rgb(0, 96, 128))
            textSize = 14f
            gravity = Gravity.CENTER
            setPadding(dp(20), dp(12), dp(20), dp(12))
            setOnClickListener {
                dialog.dismiss()
                requestUninstall(app)
            }
        }

        actions.addView(cancel)
        actions.addView(ok)
        content.addView(title)
        content.addView(message)
        content.addView(actions)

        dialog.setContentView(content)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setOnShowListener {
            dialog.window?.apply {
                setGravity(Gravity.BOTTOM)
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
        dialog.show()
    }

    private fun requestUninstall(app: LauncherApp) {
        val packageUri = Uri.fromParts("package", app.packageName, null)
        val uninstallIntent = Intent(Intent.ACTION_DELETE, packageUri)
        runCatching {
            activity.startActivity(uninstallIntent)
        }.onFailure {
            val fallbackIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri)
            runCatching { activity.startActivity(fallbackIntent) }.onFailure {
                showError(activity.getString(R.string.launcher_default_prompt_failed))
            }
        }
    }

    private fun dp(value: Int): Int {
        return (value * activity.resources.displayMetrics.density).toInt()
    }
}
