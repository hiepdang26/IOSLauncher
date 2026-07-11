package com.vhmsoft.launcherios26.features.widgets

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import com.vhmsoft.launcherios26.core.Preferences
import com.vhmsoft.launcherios26.core.database.LauncherDB
import com.vhmsoft.launcherios26.features.widgets.DefaultWidgets.privacyWidget
import timber.log.Timber

object WidgetMigration {
    @JvmStatic
    fun migrateAdvancedPrivacy(context: Context) {
        Timber.tag(TAG).d("Starting widget migration for Advanced Privacy")
        val addedAp = com.vhmsoft.launcherios26.core.Preferences.getAddedPrivacyWidget(context)
        val oldComponent =
            ComponentName("foundation.e.advancedprivacy", "foundation.e.privacycentralapp.Widget")

        val shouldMigrate = migrate(context, addedAp, oldComponent)
        Timber.tag(TAG).d("Should migrate?: $shouldMigrate")

        if (shouldMigrate && !com.vhmsoft.launcherios26.core.Preferences.getApMigration1Status(context)) {
            com.vhmsoft.launcherios26.core.Preferences.setRemovedPrivacyWidget(context)
            com.vhmsoft.launcherios26.core.Preferences.setApMigration1Status(context, true)
        }
    }

    private fun migrate(context: Context, isAdded: Boolean, oldComponent: ComponentName): Boolean {
        val widgetDao = com.vhmsoft.launcherios26.core.database.LauncherDB.getDatabase(context).widgetDao()
        var containsInDB = false

        for (widget in widgetDao.getAll()) {
            val info = AppWidgetManager.getInstance(context).getAppWidgetInfo(widget.id)
            Timber.tag(TAG).d("Widget Id: ${widget.id} | Widget info: $info")

            if (info != null && (info.provider == oldComponent || info.provider == privacyWidget)) {
                Timber.tag(TAG).d("Migrating widget ${info.provider}")
                containsInDB = true
            }
        }

        if (containsInDB && isAdded) {
            com.vhmsoft.launcherios26.core.Preferences.setApMigration1Status(context, true)
        }

        return !containsInDB && isAdded
    }

    private const val TAG = "WidgetMigration"
}
