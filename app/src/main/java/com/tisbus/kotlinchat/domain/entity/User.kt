package com.tisbus.kotlinchat.domain.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("id")
    val id: Int = UNDEFINED_ID,
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}

