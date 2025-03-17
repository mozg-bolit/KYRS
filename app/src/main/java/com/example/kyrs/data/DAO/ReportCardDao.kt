package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.Models.ReportCard

@Dao
interface ReportCardDao {
    @Insert
    suspend fun insertReportCardDao(reportCard: ReportCard)

    @Update
    suspend fun updateReportCardDao(reportCard: ReportCard)

    @Delete
    suspend fun deleteReportCardDao(reportCard: ReportCard)

    @Query("SELECT * FROM report_card")
    suspend fun getAllReportCardDao(): List<ReportCard>

    @Query("SELECT * FROM report_card WHERE id = :report_cardId")
    suspend fun getReportCardDaoById(report_cardId: Int): ReportCard?
}
