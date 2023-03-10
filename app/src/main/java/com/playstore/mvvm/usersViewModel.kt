package com.playstore.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class usersViewModel(private val usersRepository: usersRepository) : ViewModel() {
    val userList = MutableLiveData<List<User>>()
    val errorMsg = MutableLiveData<String>()

    fun getAllUserList() {
      val response =  usersRepository.getAllUsers()
        response.enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }
        })
    }
}


