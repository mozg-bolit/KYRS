package com.example.kyrs.data.Models

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "employee_handbook_payment",
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
    )
data class EmployeeHandbookPayment (
    var employee_id:Int,
    var handbook_payment_id:Int
)