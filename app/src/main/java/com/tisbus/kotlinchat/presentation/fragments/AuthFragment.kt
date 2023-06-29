package com.tisbus.kotlinchat.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.tisbus.kotlinchat.R
import com.tisbus.kotlinchat.data.services.ApiService
import com.tisbus.kotlinchat.data.services.RetrofitChat
import com.tisbus.kotlinchat.databinding.FragmentAuthBinding
import com.tisbus.kotlinchat.domain.entity.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthFragment : androidx.fragment.app.Fragment() {

    private var _bind: FragmentAuthBinding? = null
    private val bind: FragmentAuthBinding
        get() = _bind ?: throw RuntimeException("FragmentAuthBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _bind = FragmentAuthBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(bind) {
            bEnterLogin.setOnClickListener {
                authUser()
            }
            bReg.setOnClickListener {
                findNavController().navigate(R.id.action_authFragment_to_regFragment)
            }
        }
    }

    private fun authUser() {
        val apiService = RetrofitChat.getInstance().create(ApiService::class.java)
        val loginName = bind.tilLogin.editText?.text.toString().trim()
        val password = bind.tilPassword.editText?.text.toString().trim()
        val response = apiService.getUser(loginName)
        response.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                if (response.body()?.password.equals(password)) {
                    val bundle = bundleOf(NAME_USER to loginName)
                    findNavController().navigate(R.id.action_authFragment_to_chatFragment, bundle)
                }
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                Log.d("errorLogin", t.toString())
            }
        })
    }
    companion object{
        private const val NAME_USER = "user"
    }
}