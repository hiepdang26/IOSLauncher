package com.cloudx.ios17.core.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cloudx.ios17.core.database.model.WidgetItem

@Dao
interface WidgetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(widgetItem: WidgetItem): Long

    @Query("UPDATE widget_items SET height = :height WHERE id = :id")
    fun updateHeight(id: Int, height: Int)

    @Query("SELECT height FROM widget_items WHERE id = :id")
    fun getHeight(id: Int): Int

    @Query("SELECT * FROM widget_items")
    fun getAll(): List<WidgetItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(widgetItems: List<WidgetItem>)

    @Query("DELETE FROM widget_items WHERE id = :id")
    fun delete(id: Int)
}
