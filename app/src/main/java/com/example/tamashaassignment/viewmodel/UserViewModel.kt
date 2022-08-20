package com.example.tamashaassignment.viewmodel

import  android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tamashaassignment.model.Data
import com.example.tamashaassignment.network.UserReciever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val userReciever: UserReciever):ViewModel() {

    val m_response :MutableLiveData<List<Data>> =MutableLiveData()

    fun getUsers(){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = userReciever.getUsers()
                    m_response.postValue(response.data)
                Log.d("mainTest", "${response.toString()}")


            } catch (exception: Exception) {

                Log.d("mainTest", "getmsg- ${exception.message}")
            }

        }
        }
    }
