package com.tisbus.kotlinchat.domain.usecase

import androidx.lifecycle.LiveData
import com.tisbus.kotlinchat.domain.entity.Message
import com.tisbus.kotlinchat.domain.repository.MessageRepository

class GetListMessageUseCase(private val repository: MessageRepository) {
    fun getListMessageUseCase() : LiveData<MutableList<Message>>{
        return repository.getMessageList()
    }
}