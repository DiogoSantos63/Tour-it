package com.tour_it.producer.interfaces

import com.tour_it.producer.models.User
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser: Flow<User?>
    val currentUserId: String
    fun hasUser(): Boolean
    suspend fun signIn(email: String, password: String)
    suspend fun signUp(email:String, password: String, userName: String)
    suspend fun signOut(email:String,password: String)
    suspend fun deleteAccount()
}