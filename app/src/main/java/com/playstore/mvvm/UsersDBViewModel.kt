package com.playstore.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersDBViewModel constructor(private val userDBRepository: UserDBRepository) : ViewModel() {
    val userList = MutableLiveData<List<User>>()
    val errorMsg = MutableLiveData<String>()

   suspend  fun getAllUsers(){
        val response = userDBRepository.getAllUsers()
        userList.postValue(response)
    }

   suspend fun insertUsers(userList:List<User>){
        userDBRepository.insertUsers(userList)
    }
}