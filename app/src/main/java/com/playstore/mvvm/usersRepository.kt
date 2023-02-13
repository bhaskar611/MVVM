package com.playstore.mvvm

import javax.inject.Inject

class usersRepository @Inject constructor(private val userInterface: UserInterface) {

    fun getAllUsers() = userInterface.getPosts()
}