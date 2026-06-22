package com.cloudx.ios17.features.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R
import com.cloudx.ios17.core.customviews.RoundedWidgetView
import com.cloudx.ios17.core.utils.isWorkspaceDarkText
import com.cloudx.ios17.features.launcher.LauncherActivity
import timber.log.Timber

object WidgetViewBuilder {
    private const val TAG = "WidgetViewBuilder"
    const val WIDGET_OPTION_DARK_TEXT = "com.cloudx.ios17.WIDGET_OPTION_DARK_TEXT"

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
