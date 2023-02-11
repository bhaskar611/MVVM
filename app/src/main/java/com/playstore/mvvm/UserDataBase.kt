package com.playstore.mvvm


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        private var instance :UserDataBase? = null

        fun getInstance(ctx: Context) : UserDataBase {
                if (instance == null)
                    instance = Room.databaseBuilder(ctx.applicationContext,UserDataBase::class.java,
                        "user_database").fallbackToDestructiveMigration()
                        .build()


            return instance!!
        }
    }

}