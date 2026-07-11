package com.vhmsoft.launcherios26.features.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.customviews.RoundedWidgetView
import com.vhmsoft.launcherios26.core.utils.isWorkspaceDarkText
import com.vhmsoft.launcherios26.features.launcher.LauncherActivity
import timber.log.Timber

object WidgetViewBuilder {
    private const val TAG = "WidgetViewBuilder"
    const val WIDGET_OPTION_DARK_TEXT = "com.vhmsoft.launcherios26.WIDGET_OPTION_DARK_TEXT"

    @JvmStatic
    fun create(
        launcherActivity: LauncherActivity,
        roundedWidgetView: RoundedWidgetView
    ): RoundedWidgetView? {
        if (BlissLauncher.getApplication(launcherActivity).appWidgetHost == null) {
            return null
        }
        roundedWidgetView.post {
            updateWidgetOption(
                launcherActivity,
                roundedWidgetView,
                roundedWidgetView.appWidgetInfo
            )
        }

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val margin = launcherActivity.resources.getDimensionPixelSize(R.dimen.widget_margin)
        layoutParams.setMargins(0, margin, 0, margin)
        roundedWidgetView.layoutParams = layoutParams

        roundedWidgetView.setOnLongClickListener {
            val widgetProviderInfo = roundedWidgetView.appWidgetInfo
            if ((widgetProviderInfo.resizeMode and AppWidgetProviderInfo.RESIZE_VERTICAL) ==
                AppWidgetProviderInfo.RESIZE_VERTICAL
            ) {
                launcherActivity.showWidgetResizeContainer(roundedWidgetView)
            } else {
                Timber.tag(TAG).i(launcherActivity.getString(R.string.widget_is_not_resizable))
            }
            true
        }

        return roundedWidgetView
    }

    private fun updateWidgetOption(
        context: Context,
        roundedWidgetView: RoundedWidgetView,
        info: AppWidgetProviderInfo
    ) {
        val deviceProfile = BlissLauncher.getApplication(context).deviceProfile
        val newOptions = Bundle()
        newOptions.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH, deviceProfile.maxWidgetWidth)
        newOptions.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH, deviceProfile.maxWidgetWidth)
        newOptions.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT, info.minHeight)
        newOptions.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT, deviceProfile.maxWidgetHeight)
        newOptions.putBoolean(WIDGET_OPTION_DARK_TEXT, isWorkspaceDarkText(context))
        roundedWidgetView.updateAppWidgetOptions(newOptions)
    }
}
