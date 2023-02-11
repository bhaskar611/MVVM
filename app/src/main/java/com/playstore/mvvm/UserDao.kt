package com.playstore.mvvm

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun inserUserList(list: List<User>)

    @Query("select * from User")
    suspend  fun getUserList() : List<User>
}