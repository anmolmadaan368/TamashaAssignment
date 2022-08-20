package com.example.tamashaassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.tamashaassignment.network.UserReciever

class UserViewModelFactory(private val userReciever: UserReciever):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userReciever) as T
    }

}