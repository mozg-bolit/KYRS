package com.example.kyrs.data

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
    var password:String
)