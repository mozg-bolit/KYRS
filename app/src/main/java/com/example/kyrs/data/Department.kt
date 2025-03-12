package com.example.kyrs.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Департамент")
data class Department (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "desсription")
    var desсription :String,
    @ColumnInfo(name = "name")
    var name:String,
    //cheif_id_id_Int потом глянуть!!!
)