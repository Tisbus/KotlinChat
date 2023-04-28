package com.tisbus.kotlinchat.data.services

import com.tisbus.kotlinchat.domain.entity.User
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("users/{name}")
    fun getUser(@Path("name") name : String) : Call<User?>

    @Headers("Content-Type: application/json")
    @POST("users")
    fun addUser(@Body user : User?) : Call<User?>
}
