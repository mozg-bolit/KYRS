package com.example.kyrs.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Выплаты")
data class HandbookPayment (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,

    @ColumnInfo(name = "date_payment")
    var date_payment: Date,
    @ColumnInfo(name = "payout_amount")
    var paymyout_amount:Int
)