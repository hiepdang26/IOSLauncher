package com.vhmsoft.launcherios26.core.database.converters

import androidx.room.TypeConverter

object CharSequenceConverter {
    @TypeConverter
    @JvmStatic
    fun toString(value: CharSequence?): String? = value?.toString()

    @TypeConverter
    @JvmStatic
    fun toCharSequence(value: String?): CharSequence? = value
}
