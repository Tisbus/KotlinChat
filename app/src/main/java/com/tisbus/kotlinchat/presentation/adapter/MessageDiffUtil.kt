package com.tisbus.kotlinchat.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tisbus.kotlinchat.domain.entity.Message

class MessageDiffUtil(
    private val newList : List<Message>,
    private val oldList : List<Message>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}