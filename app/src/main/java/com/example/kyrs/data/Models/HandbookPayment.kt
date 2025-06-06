package com.example.kyrs.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "handbook_payment")
data class HandbookPayment (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,

    @ColumnInfo(name = "date_payment")
    var date_payment: Long,
    @ColumnInfo(name = "payout_amount")
    var paymyout_amount:Int
)