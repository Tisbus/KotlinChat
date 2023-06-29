package com.tisbus.kotlinchat.domain.usecase

import com.tisbus.kotlinchat.domain.entity.Message
import com.tisbus.kotlinchat.domain.repository.MessageRepository

class GetItemMessageUseCase(private val repository: MessageRepository) {
    fun getItemMessageUseCase(id : Int) : Message {
        return  repository.getMessageItem(id)
    }
}