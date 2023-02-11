package com.playstore.mvvm

class usersRepository constructor(private val userInterface: UserInterface) {

    fun getAllUsers() = userInterface.getPosts()
}