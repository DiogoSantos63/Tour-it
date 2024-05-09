package com.tour_it.sources.firebase.services

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.models.User
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class AccountServiceImpl() : AccountService {

    override val currentUser: Flow<User?>
        get() = callbackFlow {
            val listener = FirebaseAuth.AuthStateListener { auth ->
                this.trySend(auth.currentUser?.let { User(it.uid, it.displayName ?: "User") })
            }
            Firebase.auth.addAuthStateListener(listener)
            awaitClose { Firebase.auth.removeAuthStateListener(listener) }
        }
    override val currentUserId: String
        get() = Firebase.auth.currentUser?.uid.orEmpty()

    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override suspend fun signIn(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun signUp(email: String, password: String, userName: String) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = Firebase.auth.currentUser
                    val profileUpdate = UserProfileChangeRequest.Builder()
                        .setDisplayName(userName)
                        .build()

                    user?.updateProfile(profileUpdate)?.addOnCompleteListener { updateTask ->
                        if (updateTask.isSuccessful) {
                            println("Perfil do usuário atualizado com sucesso.")
                        } else {
                            println("Falha ao atualizar o perfil do usuário.")
                        }
                    }
                } else {
                    println("Falha ao criar a conta: ${task.exception?.message}")
                }
            }
    }

    override suspend fun signOut(email: String, password: String) {
        Firebase.auth.signOut()
    }

    override suspend fun deleteAccount() {

    }
}