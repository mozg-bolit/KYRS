package com.example.kyrs.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "Сотрудник",
    foreignKeys = [
        ForeignKey(
            entity = Department::class,
            parentColumns = ["id"], // Столбец в таблице Department
            childColumns = ["department_id_id"], // Столбец в текущей таблице (Employee)
            onDelete = ForeignKey.CASCADE // Действие при удалении
        ),
        ForeignKey(
            entity = Job::class,
            parentColumns = ["id"], // Столбец в таблице Job
            childColumns = ["job_id_id"], // Столбец в текущей таблице (Employee)
            onDelete = ForeignKey.CASCADE // Действие при удалении
        )
    ]
)
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "date_admission")
    var date_admission: Date,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "patronymic")
    var patronymic: String,

    @ColumnInfo(name = "surname")
    var surname: String,

    @ColumnInfo(name = "department_id_id") // Добавлено поле для внешнего ключа
    var department_id_id: Int,

    @ColumnInfo(name = "job_id_id") // Добавлено поле для внешнего ключа
    var job_id_id: Int
)