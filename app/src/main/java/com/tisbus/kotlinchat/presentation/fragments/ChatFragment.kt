package com.tisbus.kotlinchat.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tisbus.kotlinchat.data.services.ApiService
import com.tisbus.kotlinchat.data.services.RetrofitChat
import com.tisbus.kotlinchat.databinding.FragmentChatBinding
import com.tisbus.kotlinchat.domain.entity.Message
import com.tisbus.kotlinchat.presentation.adapter.MessageAdapter
import com.tisbus.kotlinchat.presentation.viewmodel.MessageViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatFragment : Fragment() {

    private var name: String? = null

    private var _bind: FragmentChatBinding? = null
    private val bind: FragmentChatBinding
        get() = _bind ?: throw RuntimeException("FragmentChatBinding == null")

    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageViewModel: MessageViewModel
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_USER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _bind = FragmentChatBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageViewModel = ViewModelProvider(this)[MessageViewModel::class.java]
        setupApiService()
        updateChat()
        setupRecycler()
        buttonEnterText()
    }

    private fun buttonEnterText() {
        with(bind){
            bEnterText.setOnClickListener {
                addMessToDB()
                getAllMessageToDB()
                scrollDown()
            }
        }
    }

    private fun scrollDown(){
        with(bind){
            recyclerListMessage.scrollToPosition((recyclerListMessage.adapter?.itemCount
                ?: throw java.lang.RuntimeException("item == null")) -1)
        }
    }
    private fun updateChat() {
        messageViewModel.getListMessage.observe(viewLifecycleOwner) {
            messageAdapter.submitList(it)
            scrollDown()
        }
    }

    private fun getAllMessageToDB() {
        Thread.sleep(100)
        val responseGet = apiService.getMessage()
        responseGet.enqueue(object : Callback<List<Message?>> {
            override fun onResponse(
                call: Call<List<Message?>>,
                response: Response<List<Message?>>,
            ) {
                messageViewModel.deleteAllMessage()
                response.body()?.forEach { i ->
                    if (i != null) {
                        messageViewModel.addItemMessage(
                            i.username,
                            i.text,
                            i.id
                        )
                    }
                }

            }
            override fun onFailure(call: Call<List<Message?>>, t: Throwable) {
                Log.d("errorLogin", t.toString())
            }
        })
    }

    private fun setupApiService() {
        apiService = RetrofitChat.getInstance().create(ApiService::class.java)
    }

    private fun addMessToDB() {
        val mes = Message(
            name.toString(),
            bind.etFieldText.text.toString()
        )
        val responseAdd = apiService.addMessage(mes)

        responseAdd.enqueue(object : Callback<Message?> {
            override fun onResponse(call: Call<Message?>, response: Response<Message?>) {

            }

            override fun onFailure(call: Call<Message?>, t: Throwable) {

            }
        })
        bind.etFieldText.setText("")
    }

    private fun setupRecycler(): RecyclerView {
        val recycler = bind.recyclerListMessage
        with(recycler) {
            messageAdapter = MessageAdapter()
            adapter = messageAdapter
        }
        return recycler
    }

    companion object {
        private const val NAME_USER = "user"
    }
}