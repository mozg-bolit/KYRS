package com.example.kyrs.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "employee",
    foreignKeys = [
        ForeignKey(
            entity = Department::class,
            parentColumns = ["id"], // Столбец в таблице Department
            childColumns = ["department_id"], // Столбец в текущей таблице (Employee)
            onDelete = ForeignKey.CASCADE // Действие при удалении
        ),
        ForeignKey(
            entity = Job::class,
            parentColumns = ["id"], // Столбец в таблице Job
            childColumns = ["job_id"], // Столбец в текущей таблице (Employee)
            onDelete = ForeignKey.CASCADE // Действие при удалении
        ),
        ForeignKey(
            entity = ListDeduction::class,
            parentColumns = ["id"],
            childColumns = ["list_deduction_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "date_admission")
    var date_admission: Long,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "patronymic")
    var patronymic: String,

    @ColumnInfo(name = "surname")
    var surname: String,

    @ColumnInfo(name = "department_id") // Добавлено поле для внешнего ключа
    var department_id: Int,

    @ColumnInfo(name = "job_id") // Добавлено поле для внешнего ключа
    var job_id: Int,

    @ColumnInfo(name = "list_deduction_id")
    var list_deduction_id:Int,

    @ColumnInfo(name = "report_card")
    var reportCard: List<ReportCard>,

    @ColumnInfo(name = "handbook_payment")
    var handbookPayment: List<HandbookPayment>
)