package com.example.latihanmobileapp.UserData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Long = 0,
    val nama: String,
    val email: String,
    val password: String
)
