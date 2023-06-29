package com.tisbus.kotlinchat.domain.usecase

import com.tisbus.kotlinchat.domain.repository.MessageRepository

class DeleteAllMessageUseCase(private val repository: MessageRepository) {
    fun deleteAllMessage() {
        repository.deleteAllMessage()
    }
}