package com.example.tamashaassignment.network

import com.example.tamashaassignment.model.Data
import com.example.tamashaassignment.model.Users
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserReciever {


    companion object{





        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val networkInterface: NetworkInterface by lazy {
            retrofit.create(NetworkInterface::class.java)
        }
    }


    init {

    }

    suspend fun getUsers(): Users {
        return networkInterface.getUsers()
    }
}