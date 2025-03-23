package com.example.kyrs.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kyrs.data.Models.Message


@Dao
interface MessageDao {

    @Insert
    suspend fun insertmessage(message: Message)

    @Delete
    suspend fun deletemessage(message: Message)

    @Update
    suspend fun updatemessage(message: Message)

    @Query("SELECT * FROM message")
    suspend fun getAllMessage():List<Message>

}