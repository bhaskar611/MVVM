package com.playstore.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class userViewModelFactory constructor(private val usersRepository: usersRepository)
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(usersViewModel::class.java)) {
                usersViewModel(this.usersRepository) as T
        } else{
             throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}