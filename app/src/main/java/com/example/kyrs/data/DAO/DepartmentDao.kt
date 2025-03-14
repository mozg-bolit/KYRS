package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.Department
import com.example.kyrs.data.User

@Dao
interface DepartmentDao {
    @Insert
    suspend fun insertDepartment(department: Department)

    @Update
    suspend fun updateDepartment(department: Department)

    @Delete
    suspend fun deleteDepartment(department: Department)

    @Query("SELECT * FROM department")
    suspend fun getAllDepartments(): List<Department>

    @Query("SELECT * FROM department WHERE id = :departmentId")
    suspend fun getDepartmentById(departmentId: Int): Department?
}
