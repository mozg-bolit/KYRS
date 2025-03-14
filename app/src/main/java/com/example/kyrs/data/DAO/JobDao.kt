package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.HandbookPayment
import com.example.kyrs.data.Job

@Dao
interface JobDao {
    @Insert
    suspend fun insertJob(job: Job)

    @Update
    suspend fun updateJob(job: Job)

    @Delete
    suspend fun deleteJob(job:Job)

    @Query("SELECT * FROM job")
    suspend fun getAllJobs(): List<Job>

    @Query("SELECT * FROM job WHERE id = :jobId")
    suspend fun getJobById(jobId: Int): Job?
}
