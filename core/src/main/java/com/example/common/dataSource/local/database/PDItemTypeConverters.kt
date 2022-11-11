package com.example.common.dataSource.local.database

import androidx.room.TypeConverter

class PDItemTypeConverters {

    @TypeConverter
    fun fromListToString(list: List<String?>): String {
        return list.toString().substringAfter("[").substringBefore("]")
    }

    @TypeConverter
    fun fromStringToList(data: String): List<String?> {
        return data.split(", ")
    }
}