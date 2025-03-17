package com.example.kyrs.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "report_card")
data class ReportCard(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "date")
    var date: Long,

    @ColumnInfo(name = "hours_worked")
    var hours_worked: Int
)