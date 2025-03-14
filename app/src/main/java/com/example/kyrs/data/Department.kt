package com.example.kyrs.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (tableName = "department",
        foreignKeys = [
            ForeignKey(
                entity = Employee::class,
                parentColumns = ["id"],
                childColumns = ["cheif_id"],
                onDelete = ForeignKey.CASCADE
            )
        ]
    )
data class Department (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "desсription")
    var desсription :String,
    @ColumnInfo(name = "name")
    var name:String,
    var cheif_id:Int
)