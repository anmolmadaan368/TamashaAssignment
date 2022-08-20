package com.example.tamashaassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tamashaassignment.model.Data
import com.example.tamashaassignment.viewmodel.UserViewModel
import com.example.tamashaassignment.viewmodel.UserViewModelFactory
import com.example.tamashaassignment.network.UserReciever
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_item.*

class MainActivity : AppCompatActivity() {
    private val userReciever:UserReciever = UserReciever()
    private lateinit var usersAdapter: UsersAdapter
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        val viewModelFactory = UserViewModelFactory(userReciever)
        userViewModel = ViewModelProvider(this,viewModelFactory)[UserViewModel::class.java]
        userViewModel.getUsers()
        userViewModel.m_response.observe(this, Observer {
            usersAdapter.setUserData(it as ArrayList<Data>)
            recyclerView.visibility = View.VISIBLE
        })


    }


    private fun initRecyclerView(){

        usersAdapter = UsersAdapter(this, ArrayList())
        recyclerView.apply {

            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = usersAdapter

        }}
}