package com.example.tamashaassignment.network


import com.example.tamashaassignment.model.Data
import com.example.tamashaassignment.model.Users
import retrofit2.http.GET

interface NetworkInterface {

    @GET("v1/61cf7d91-a7f8-405e-b505-67926b759d78")
    suspend fun getUsers():Users
}