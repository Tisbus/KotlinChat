package com.tisbus.kotlinchat.domain.entity

import com.google.gson.annotations.SerializedName

data class User(
    val email: String,
    val name: String,
    val password: String,
    val userDate: Long,
    val success: Long,
    val id: Int = UNDEFINED_ID,
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}

