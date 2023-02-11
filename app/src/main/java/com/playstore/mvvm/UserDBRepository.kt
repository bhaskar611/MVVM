package com.playstore.mvvm

class UserDBRepository constructor(private val userDao: UserDao) {
  suspend  fun getAllUsers() = userDao.getUserList()

  suspend  fun insertUsers(userList : List<User>) = userDao.inserUserList(userList)
}