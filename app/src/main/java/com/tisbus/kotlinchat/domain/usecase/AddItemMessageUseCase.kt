package com.tisbus.kotlinchat.domain.usecase

import com.tisbus.kotlinchat.domain.entity.Message
import com.tisbus.kotlinchat.domain.repository.MessageRepository

class AddItemMessageUseCase (private val repository: MessageRepository) {
    fun addItemMessageUseCase(item : Message){
        repository.addMessageItem(item)
    }
}