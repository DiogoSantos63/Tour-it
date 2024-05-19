package com.tour_it.sources.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val userID: Int = 0,
    val name: String,
    val points: Int = 5
)