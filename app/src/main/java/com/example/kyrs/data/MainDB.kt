package com.example.kyrs.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kyrs.data.DAO.DeductionDao
import com.example.kyrs.data.DAO.DepartmentDao
import com.example.kyrs.data.DAO.EmployeeDao
import com.example.kyrs.data.DAO.HandbookPaymentDao
import com.example.kyrs.data.DAO.JobDao
import com.example.kyrs.data.DAO.ListDeductionDao
import com.example.kyrs.data.DAO.ReportCardDao
import com.example.kyrs.data.DAO.UserDao
import com.example.kyrs.data.Models.Converters
import com.example.kyrs.data.Models.Deduction
import com.example.kyrs.data.Models.Department
import com.example.kyrs.data.Models.Employee
import com.example.kyrs.data.Models.EmployeeHandbookPayment
import com.example.kyrs.data.Models.EmployeeListDeduction
import com.example.kyrs.data.Models.EmployeeReportCard
import com.example.kyrs.data.Models.HandbookPayment
import com.example.kyrs.data.Models.Job
import com.example.kyrs.data.Models.ListDeduction
import com.example.kyrs.data.Models.ReportCard
import com.example.kyrs.data.Models.User

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
        ReportCard::class,
        EmployeeListDeduction::class,
        ListDeduction::class
    ],
    version = 3
)
@TypeConverters(Converters::class)
abstract class MainDB : RoomDatabase() {//
    abstract fun getEmployeeDao(): EmployeeDao
    abstract fun getUserDao(): UserDao
    abstract fun getDepartmentDao(): DepartmentDao
    abstract fun getDeductionDao(): DeductionDao
    abstract fun getHandbookPaymentDao(): HandbookPaymentDao
    abstract fun getJobDao(): JobDao
    abstract fun getListDeductionDao(): ListDeductionDao
    abstract fun getReportCardDao(): ReportCardDao

    companion object {//
        @Volatile
        private var INSTANCE: MainDB? = null

        val Migration_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
            }
        }

        fun getDb(context: Context): MainDB {
            return Room.databaseBuilder( //
                    context.applicationContext,//
                    MainDB::class.java,//
                    "kurs.db"//
                ).addMigrations(Migration_1_2) // Используем миграцию
                //для удаления    .fallbackToDestructiveMigration()
                    .build()//
            }
        }
    }
///////// -> // обяз элем