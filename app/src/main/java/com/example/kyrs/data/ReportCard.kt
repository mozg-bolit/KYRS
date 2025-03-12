package com.example.kyrs.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "report_card")
data class ReportCard(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "date")
    var date: Date,

    @ColumnInfo(name = "hours_worked")
    var hours_worked: Int
)