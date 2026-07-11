package com.vhmsoft.launcherios26.core.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vhmsoft.launcherios26.core.database.model.LauncherItem
import com.vhmsoft.launcherios26.core.utils.Constants

@Dao
interface LauncherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(launcherItem: LauncherItem): Long

    @Query("SELECT * FROM launcher_items ORDER BY container, screen_id, cell")
    fun getAllItems(): List<LauncherItem>

    @Query("SELECT item_id FROM launcher_items WHERE package = :packageName")
    fun getComponentName(packageName: String): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(launcherItems: List<LauncherItem>)

    @Query("DELETE FROM launcher_items WHERE item_id = :id")
    fun delete(id: String)

    @Query("DELETE FROM launcher_items WHERE package = :packageName")
    fun deletePackage(packageName: String)

    @Query("DELETE FROM launcher_items WHERE title = :name and item_type = " + Constants.ITEM_TYPE_SHORTCUT)
    fun deleteShortcut(name: String)

    @Query("UPDATE launcher_items SET item_id = :newComponentName WHERE item_id = :id")
    fun updateComponent(id: String, newComponentName: String): Int
}
