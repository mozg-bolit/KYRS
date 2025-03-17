package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.Models.HandbookPayment

@Dao
interface HandbookPaymentDao {
    @Insert
    suspend fun insertHandbookPayment(handbookPayment: HandbookPayment)

    @Update
    suspend fun updateHandbookPayment(handbookPayment: HandbookPayment)

    @Delete
    suspend fun deleteHandbookPayment(handbookPayment: HandbookPayment)

    @Query("SELECT * FROM handbook_payment")
    suspend fun getAllHandbookPayments(): List<HandbookPayment>

    @Query("SELECT * FROM handbook_payment WHERE id = :handbook_paymentId")
    suspend fun getHandbookPaymentById(handbook_paymentId: Int): HandbookPayment?
}