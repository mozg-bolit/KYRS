package com.example.kyrs.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity (tableName = "list_deduction",
    foreignKeys = [
        ForeignKey(
            entity = Deduction::class,
            parentColumns = ["id"],
            childColumns = ["deduction_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ListDeduction(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    @ColumnInfo(name = "date")
    var date:Long,
    var deduction_id:Int //Поле для внеш ключа
)