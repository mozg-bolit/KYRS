package com.example.kyrs.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        Employee::class,
        HandbookPayment::class,
        EmployeeHandbookPayment::class,
        EmployeeReportCard::class,
        Department::class,
        Deduction::class,
        User::class,
        Job::class,
        ReportCard::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MainDB : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        fun getDb(context: Context): MainDB {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "Курс.db"
            ).build()
        }
    }
}