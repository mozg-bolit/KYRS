package com.example.kyrs.data.Models

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "employee_list_deduction",
    primaryKeys = ["employee_id","list_deduction_id"],
    foreignKeys = [
        ForeignKey(
            entity = Employee::class,
            parentColumns = ["id"],
            childColumns = ["employee_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(
            entity = ListDeduction::class,
            parentColumns = ["id"],
            childColumns = ["list_deduction_id"],
            onDelete = ForeignKey.CASCADE)
        ]
    )
data class EmployeeListDeduction (
    var employee_id:Int,
    var list_deduction_id:Int
)