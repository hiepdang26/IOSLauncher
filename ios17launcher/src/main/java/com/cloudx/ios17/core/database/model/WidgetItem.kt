package com.cloudx.ios17.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "widget_items")
class WidgetItem() {
    @field:PrimaryKey
    @JvmField
    var id: Int = 0

    @field:ColumnInfo(defaultValue = "0")
    @JvmField
    var height: Int = 0

    @field:ColumnInfo(defaultValue = "99999")
    @JvmField
    var order: Int = DEFAULT_ORDER

    constructor(id: Int) : this() {
        this.id = id
    }

    companion object {
        const val DEFAULT_ORDER = 99999
    }
}
