package com.playstore.mvvm

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    val baseUrl = "https://jsonplaceholder.typicode.com"


    @Provides
    @Singleton
    fun getRetrofitServiceInsatnce(retrofit: Retrofit):UserInterface {
        return retrofit.create(UserInterface::class.java)
    }



    @Provides
    @Singleton
    fun getRetrofitInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun getAppDatabase(context:Application): UserDataBase{
        return UserDataBase.getInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(userDataBase: UserDataBase) : UserDao{
        return userDataBase.userDao()
    }


}