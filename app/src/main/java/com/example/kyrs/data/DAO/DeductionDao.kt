package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.Deduction
import com.example.kyrs.data.Department

@Dao
interface DeductionDao {
    @Insert
    suspend fun insertDeduction(deduction: Deduction)

    @Update
    suspend fun updateDeduction(deduction: Deduction)

    @Delete
    suspend fun deleteDeduction(deduction: Deduction)

    @Query("SELECT * FROM deduction")
    suspend fun getAllDeductions(): List<Deduction>

    @Query("SELECT * FROM deduction WHERE id = :deductionId")
    suspend fun getDeductionById(deductionId: Int): Deduction?
}