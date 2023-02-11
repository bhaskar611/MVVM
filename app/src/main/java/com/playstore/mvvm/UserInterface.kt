package com.playstore.mvvm

import retrofit2.Call
import retrofit2.http.GET

interface UserInterface {
    @GET("posts/1")
    fun getPost() : User

    @GET("posts")
    fun getPosts() : Call<List<User>>
}