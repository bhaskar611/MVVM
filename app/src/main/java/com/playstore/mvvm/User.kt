package com.playstore.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val completed: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val userId: Int
)