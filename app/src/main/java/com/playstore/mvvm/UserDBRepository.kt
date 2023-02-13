package com.playstore.mvvm

import javax.inject.Inject

class UserDBRepository @Inject constructor(private val userDao: UserDao) {
  suspend  fun getAllUsers() = userDao.getUserList()

  suspend  fun insertUsers(userList : List<User>) = userDao.inserUserList(userList)
}