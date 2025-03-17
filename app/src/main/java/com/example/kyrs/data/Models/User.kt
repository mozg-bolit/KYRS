package com.example.kyrs.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,

    @ColumnInfo(name = "username")
    var username:String,
    @ColumnInfo(name = "password")
    var password:String,

    @ColumnInfo(name = "token")
    var token:String
)