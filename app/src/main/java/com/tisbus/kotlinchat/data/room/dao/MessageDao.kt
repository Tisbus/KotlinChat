package com.tisbus.kotlinchat.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tisbus.kotlinchat.domain.entity.Message

@Dao
interface MessageDao {
    @Query("SELECT * from message")
    fun getMessageList(): LiveData<MutableList<Message>>

    @Query("SELECT * from message where id=:id")
    fun getMessageItem(id: Int): Message

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMessage(item: Message)

    @Query("Delete from message")
    fun deleteAllMessage()
}