package com.example.kyrs.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "job")
data class Job (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,

    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "payout")
    var payout:Int
)