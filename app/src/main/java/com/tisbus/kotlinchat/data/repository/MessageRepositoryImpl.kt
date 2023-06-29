package com.tisbus.kotlinchat.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.tisbus.kotlinchat.data.room.dao.MessageDao
import com.tisbus.kotlinchat.data.room.database.DataBase
import com.tisbus.kotlinchat.domain.entity.Message
import com.tisbus.kotlinchat.domain.repository.MessageRepository

class MessageRepositoryImpl(application: Application) : MessageRepository {

    private val messageDao: MessageDao = DataBase.getInstance(application).messageDao()

    override fun getMessageList(): LiveData<MutableList<Message>> = messageDao.getMessageList()

    override fun getMessageItem(id: Int): Message {
        return messageDao.getMessageItem(id)
    }

    override fun addMessageItem(item: Message) {
        messageDao.addMessage(item)
    }

    override fun deleteAllMessage() {
        messageDao.deleteAllMessage()
    }
}