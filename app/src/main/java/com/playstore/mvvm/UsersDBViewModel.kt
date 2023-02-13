package com.playstore.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersDBViewModel @Inject constructor(private val userDBRepository: UserDBRepository) : ViewModel() {
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