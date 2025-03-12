package com.example.kyrs.data

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time // Преобразуем Date в Long (миллисекунды)
    }

    @TypeConverter
    fun toDate(millis: Long?): Date? {
        return millis?.let { Date(it) } // Преобразуем Long в Date
    }

    @TypeConverter
    fun fromDeductionType(type: DeductionType): String {
        return type.name
    }

    @TypeConverter
    fun toDeductionType(value: String): DeductionType {
        return DeductionType.valueOf(value)
    }
}