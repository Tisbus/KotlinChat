package com.tisbus.kotlinchat.data.services

import com.tisbus.kotlinchat.domain.entity.Message
import com.tisbus.kotlinchat.domain.entity.User
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST(REGISTER)
    fun addUser(@FieldMap params: Map<String, String>): Call<User>

    @FormUrlEncoded
    @POST(LOGIN)
    fun getUser(@FieldMap params: Map<String, String>): Call<User>

/*    @Headers("Content-Type: application/json")
    @GET("users/{name}")
    fun getUser(@Path("name") name: String): Call<User?>*/

/*    @Headers("Content-Type: application/json")
    @POST("users")
    fun addUser(@Body user: User?): Call<User?>*/

    @Headers("Content-Type: application/json")
    @POST("users/add")
    fun addMessage(@Body message: Message?): Call<Message?>

    @Headers("Content-Type: application/json")
    @GET("users/get_all")
    fun getMessage(): Call<List<Message?>>

    companion object{
        const val REGISTER = "register.php"
        const val PARAM_EMAIL = "email"
        const val PARAM_PASSWORD = "password"
        const val PARAM_NAME = "name"
        const val PARAM_USER_DATE = "user_date"

        const val LOGIN = "login.php"
    }
}
