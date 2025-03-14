package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.ListDeduction

@Dao
interface ListDeductionDao {
    @Insert
    suspend fun insertListDeduction(listDeduction: ListDeduction)

    @Update
    suspend fun updateListDeduction(listDeduction: ListDeduction)

    @Delete
    suspend fun deleteListDeduction(listDeduction: ListDeduction)

    @Query("SELECT * FROM list_deduction")
    suspend fun getAllListDeductions(): List<ListDeduction>

    @Query("SELECT * FROM list_deduction WHERE id = :listdeductionId")
    suspend fun getListDeductionById(listdeductionId: Int): ListDeduction?
}
