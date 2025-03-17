package com.example.kyrs.data.Models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {
    private val gson = Gson()
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
    // Конвертер для List<ReportCard>
    @TypeConverter
    fun fromReportCardList(value: List<ReportCard>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toReportCardList(value: String): List<ReportCard> {
        val type = object : TypeToken<List<ReportCard>>() {}.type
        return gson.fromJson(value, type)
    }

    // Конвертер для List<HandbookPayment>
    @TypeConverter
    fun fromHandbookPaymentList(value: List<HandbookPayment>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toHandbookPaymentList(value: String): List<HandbookPayment> {
        val type = object : TypeToken<List<HandbookPayment>>() {}.type
        return gson.fromJson(value, type)
    }
}