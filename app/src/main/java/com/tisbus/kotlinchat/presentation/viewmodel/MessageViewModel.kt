package com.tisbus.kotlinchat.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tisbus.kotlinchat.data.repository.MessageRepositoryImpl
import com.tisbus.kotlinchat.domain.entity.Message
import com.tisbus.kotlinchat.domain.usecase.AddItemMessageUseCase
import com.tisbus.kotlinchat.domain.usecase.DeleteAllMessageUseCase
import com.tisbus.kotlinchat.domain.usecase.GetItemMessageUseCase
import com.tisbus.kotlinchat.domain.usecase.GetListMessageUseCase

class MessageViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MessageRepositoryImpl(application)
    private val getMessageListUseCase = GetListMessageUseCase(repository)
    private val getItemMessageUseCase = GetItemMessageUseCase(repository)
    private val addItemMessageUseCase = AddItemMessageUseCase(repository)
    private val deleteAllMessageUseCase = DeleteAllMessageUseCase(repository)
    val getListMessage = getMessageListUseCase.getListMessageUseCase()
    fun addItemMessage(
        name: String,
        text: String,
        id : Int
    ) {
        addItemMessageUseCase.addItemMessageUseCase(
            Message(name, text, id)
        )
    }
    fun deleteAllMessage(){
        deleteAllMessageUseCase.deleteAllMessage()
    }
}