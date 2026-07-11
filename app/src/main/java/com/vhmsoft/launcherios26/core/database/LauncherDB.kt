package com.vhmsoft.launcherios26.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vhmsoft.launcherios26.core.database.converters.CharSequenceConverter
import com.vhmsoft.launcherios26.core.database.daos.LauncherDao
import com.vhmsoft.launcherios26.core.database.daos.WidgetDao
import com.vhmsoft.launcherios26.core.database.model.LauncherItem
import com.vhmsoft.launcherios26.core.database.model.WidgetItem

@Database(entities = [LauncherItem::class, WidgetItem::class], version = 5, exportSchema = false)
@TypeConverters(CharSequenceConverter::class)
abstract class LauncherDB : RoomDatabase() {
    abstract fun launcherDao(): LauncherDao
    abstract fun widgetDao(): WidgetDao

    private class UserHandleMigration(
        startVersion: Int,
        endVersion: Int,
        private val userSerialNumber: Long
    ) : Migration(startVersion, endVersion) {
        override fun migrate(database: SupportSQLiteDatabase) {
            val suffix = "\"/$userSerialNumber\""
            val query = "UPDATE launcher_items set item_id=item_id || " + suffix + "WHERE item_type <> 2"
            database.execSQL(query)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: LauncherDB? = null

        private val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `widget_items` (`id` INTEGER NOT NULL, `height` INTEGER NOT NULL, PRIMARY KEY(`id`))"
                )
            }
        }

        private val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE `widget_items` RENAME TO `widget_items_old`")
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `widget_items` (" +
                        "`id` INTEGER NOT NULL, " +
                        "`height` INTEGER NOT NULL DEFAULT 0, " +
                        "`order` INTEGER NOT NULL DEFAULT 99999, " +
                        "PRIMARY KEY(`id`))"
                )
                database.execSQL(
                    "INSERT INTO `widget_items` (`id`, `height`) SELECT `id`, `height` FROM `widget_items_old`"
                )
                database.execSQL("DROP TABLE `widget_items_old`")
            }
        }

        @JvmStatic
        fun getDatabase(context: Context): LauncherDB {
            if (INSTANCE == null) {
                synchronized(LauncherDB::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            LauncherDB::class.java,
                            "launcher_db"
                        ).addMigrations(MIGRATION_3_4, MIGRATION_4_5).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}
