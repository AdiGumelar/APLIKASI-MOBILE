package com.example.latihanmobileapp.UserData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE nama = :nama")
    fun getUserByUsername(nama: String): LiveData<User>

    @Query("SELECT * FROM user_table WHERE uid = :userId")
    fun getUserById(userId: Long): LiveData<User>
}
