package com.tisbus.kotlinchat.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.tisbus.kotlinchat.R
import com.tisbus.kotlinchat.databinding.MessageItemBinding
import com.tisbus.kotlinchat.domain.entity.Message

class MessageAdapter : ListAdapter<Message, MessageViewHolder>(MessageItemDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = DataBindingUtil.inflate<MessageItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.message_item,
            parent,
            false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val itemMessage = getItem(position)
        val bind = holder.bind
        bind.message = itemMessage
    }
}