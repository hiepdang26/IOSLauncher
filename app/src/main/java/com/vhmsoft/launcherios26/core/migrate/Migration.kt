package com.vhmsoft.launcherios26.core.migrate

import android.content.Context
import android.os.Build
import android.util.Log
import com.vhmsoft.launcherios26.core.Preferences
import com.vhmsoft.launcherios26.core.database.DatabaseManager
import com.vhmsoft.launcherios26.core.database.LauncherDB
import com.google.gson.Gson
import java.io.IOException

object Migration {

    private const val TAG = "Migration"

    @JvmStatic
    fun migrateSafely(context: Context) {
        if (Build.VERSION.SDK_INT > 28) {
            val dialerComponentList = listOf(
                "com.android.dialer/com.android.dialer.main.impl.MainActivity",
                "com.android.dialer/com.android.dialer.app.DialtactsActivity",
                "com.android.dialer/com.android.dialer.DialtactsActivity"
            )

            val currentComponent = dialerComponentList[0]
            val dialerComponent = LauncherDB.getDatabase(context).launcherDao()
                .getComponentName("com.android.dialer")

            if (
                dialerComponent != null &&
                dialerComponentList.contains(dialerComponent) &&
                dialerComponent != currentComponent
            ) {
                Log.d(TAG, "migrateSafely: Migrating dialer component!")
                DatabaseManager.getManager(context).migrateComponent(dialerComponent, currentComponent)
            }
        }

        val migrationInfo = readJSONFromAsset(context) ?: return
        val currentMigration = Gson().fromJson(migrationInfo, CurrentMigration::class.java) ?: return
        val oldVersion = Preferences.getCurrentMigrationVersion(context)
        if (oldVersion < currentMigration.currentVersion) {
            val infos = currentMigration.migrate_infos.orEmpty()
                .filter { it.startVersion >= oldVersion }
                .sorted()
            Log.i(TAG, "migrateSafely: ${infos.size}")
            for (info in infos) {
                for (component in info.components.orEmpty()) {
                    val oldComponentName = component.old_component_name ?: continue
                    val newComponentName = component.new_component_name ?: continue
                    DatabaseManager.getManager(context).migrateComponent(
                        oldComponentName,
                        newComponentName
                    )
                }
            }
            Preferences.setCurrentMigrationVersion(context, currentMigration.currentVersion)
        }
    }

    private fun readJSONFromAsset(context: Context): String? {
        return try {
            context.assets.open("migrate_info.json").use { inputStream ->
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                String(buffer, Charsets.UTF_8)
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }
}
