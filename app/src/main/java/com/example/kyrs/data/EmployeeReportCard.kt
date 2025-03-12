package com.example.kyrs.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "employee_report_card",
    primaryKeys = ["employee_id", "report_card_id"], // Составной первичный ключ
    foreignKeys = [
        ForeignKey(
            entity = Employee::class,
            parentColumns = ["id"],
            childColumns = ["employee_id"],
            onDelete = ForeignKey.CASCADE // Удаление связанных записей при удалении employee
        ),
        ForeignKey(
            entity = ReportCard::class,
            parentColumns = ["id"],
            childColumns = ["report_card_id"],
            onDelete = ForeignKey.CASCADE // Удаление связанных записей при удалении report_card
        )
    ],
    indices = [Index(value = ["employee_id", "report_card_id"], unique = true)] // Уникальный индекс
)
data class EmployeeReportCard(
    val employee_id: Int,
    val report_card_id: Int
)