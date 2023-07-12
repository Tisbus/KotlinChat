package com.tisbus.kotlinchat.data.services

import androidx.fragment.app.Fragment

data class HelpConvert(val fragment : Fragment) {
    fun createRegisterMap(
        email: String,
        name: String,
        password: String,
        userDate: Long,
    ): Map<String, String> {
        val map = HashMap<String, String>()
        map.put(ApiService.PARAM_EMAIL, email)
        map.put(ApiService.PARAM_NAME, name)
        map.put(ApiService.PARAM_PASSWORD, password)
        map.put(ApiService.PARAM_USER_DATE, userDate.toString())
        return map
    }

    fun createLoginMap(
        email: String,
        password: String,
    ): Map<String, String> {
        val map = HashMap<String, String>()
        map.put(ApiService.PARAM_EMAIL, email)
        map.put(ApiService.PARAM_PASSWORD, password)
        return map
    }
}