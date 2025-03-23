package com.example.kyrs.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "message"//,
//        foreignKeys = [
//            ForeignKey(
//                entity = Employee::class,
//                parentColumns = ["id"],
//                childColumns = ["employeeId"],
//                onDelete = ForeignKey.CASCADE
//            )
//        ]
    )
data class Message (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "surname")
    var surname:String,

    @ColumnInfo(name = "patronymic")
    var patronymic:String,

    @ColumnInfo(name = "text")
    var text:String,

    @ColumnInfo(name = "date")
    var date:Long,

    //var employeeId:Int


)