package com.example.kyrs.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "Лист",
       primaryKeys = ["employee_id","handbook_payment_id"],
        foreignKeys = [
            ForeignKey(
                entity = Employee::class,
                parentColumns = ["id"],
                childColumns = ["employee_id"],
                onDelete = ForeignKey.CASCADE
            ),
        ForeignKey(
            entity = HandbookPayment::class,
            parentColumns = ["id"],
            childColumns = ["handbook_payment_id"],
            onDelete = ForeignKey.CASCADE
        )
        ],
    indices = [Index(value = ["employee_id", "handbook_payment_id"], unique = true)]
    )
data class EmployeeHandbookPayment (
    var employee_id:Int,
    var handbook_payment_id:Int
)