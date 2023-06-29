package com.tisbus.kotlinchat.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tisbus.kotlinchat.domain.entity.Message

class MessageItemDiffUtil : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }
}