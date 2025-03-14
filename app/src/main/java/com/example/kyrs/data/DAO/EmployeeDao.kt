package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.Employee
import com.example.kyrs.data.User

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insert(employee: Employee)

    @Update
    suspend fun update(employee: Employee)

    @Delete
    suspend fun delete(employee: Employee)

    @Query("SELECT * FROM employee")
    suspend fun getAllEmployees(): List<Employee>

    @Query("SELECT * FROM employee WHERE id = :employeeId")
    suspend fun getEmployeeById(employeeId: Int): Employee?


}