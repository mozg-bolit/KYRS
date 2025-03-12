package com.example.kyrs.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Удержание")
data class Deduction(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "type")
    var typeEnum: DeductionType,
    @ColumnInfo(name = "value")
    var value: Int
)