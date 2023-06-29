package com.tisbus.kotlinchat.domain.repository

import androidx.lifecycle.LiveData
import com.tisbus.kotlinchat.domain.entity.Message

interface MessageRepository {
    fun getMessageList() : LiveData<MutableList<Message>>
    fun getMessageItem(id : Int) : Message
    fun addMessageItem(item : Message)
    fun deleteAllMessage()
}