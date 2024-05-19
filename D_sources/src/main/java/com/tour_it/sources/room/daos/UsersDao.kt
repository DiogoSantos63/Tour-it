package com.tour_it.sources.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tour_it.sources.room.entities.EventEntity
import com.tour_it.sources.room.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT points FROM users WHERE name = :userName")
    suspend fun getUserPoints(userName: String): Int

    @Query("DELETE FROM users")
    suspend fun deleteAllEvents()

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>
}