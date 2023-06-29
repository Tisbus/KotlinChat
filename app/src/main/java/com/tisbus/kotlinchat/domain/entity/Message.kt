package com.tisbus.kotlinchat.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "message")
data class Message(
    @SerializedName("name")
    val username : String,
    @SerializedName("text")
    val text : String,
    @PrimaryKey
    @SerializedName("id")
    val id : Int = UNDEFINED_ID
) {
    companion object{
        private const val UNDEFINED_ID = 0
    }
}