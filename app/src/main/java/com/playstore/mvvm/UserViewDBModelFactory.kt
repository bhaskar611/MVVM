package com.playstore.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class UserViewDBModelFactory constructor(private val userDBRepository: UserDBRepository)
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UsersDBViewModel::class.java)) {
            UsersDBViewModel(this.userDBRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}