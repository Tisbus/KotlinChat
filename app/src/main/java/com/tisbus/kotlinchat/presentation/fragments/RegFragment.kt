package com.tisbus.kotlinchat.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tisbus.kotlinchat.R
import com.tisbus.kotlinchat.data.services.ApiService
import com.tisbus.kotlinchat.data.services.HelpConvert
import com.tisbus.kotlinchat.data.services.RetrofitChat
import com.tisbus.kotlinchat.databinding.FragmentRegBinding
import com.tisbus.kotlinchat.domain.entity.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar

class RegFragment : Fragment() {

    private var _bind: FragmentRegBinding? = null
    private val bind: FragmentRegBinding
        get() = _bind ?: throw RuntimeException("FragmentRegBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _bind = FragmentRegBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind.bRegUser.setOnClickListener {
            registrationUser()
        }
    }

    private fun registrationUser() {
        val login = bind.tilLoginReg.editText?.text.toString().trim()
        val password = bind.tilPasswordReg.editText?.text.toString().trim()
        val passwordConfirm = bind.tilPasswordRegConf.editText?.text.toString().trim()
        if (password == passwordConfirm) {
            val apiService = RetrofitChat.getInstance().create(ApiService::class.java)
            val response = apiService.addUser(HelpConvert(this).createRegisterMap("email", login, password, Calendar.getInstance().timeInMillis))
            response.enqueue(object : Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {

                }

                override fun onFailure(call: Call<User?>, t: Throwable) {

                }
            })
            findNavController().navigate(R.id.action_regFragment_to_authFragment)
        }
    }
}