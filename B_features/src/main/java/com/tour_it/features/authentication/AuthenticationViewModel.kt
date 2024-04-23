package com.tour_it.features.authentication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tour_it.producer.enums.Navigation
import com.tour_it.producer.interfaces.AccountService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

const val TAG = "AuthenticationViewModel"
class AuthenticationViewModel(
    private val accountService: AccountService
): ViewModel() {

    private val email = MutableStateFlow("")
    private val password = MutableStateFlow("")

    fun updateEmail(newEmail:String){
        email.value = newEmail.trim()
    }

    fun updatePassWord(newPassword: String){
        password.value = newPassword.trim()
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit){
        viewModelScope.launch {
            runCatching {
                accountService.signIn(email.value, password.value)
                openAndPopUp(Navigation.HOMEPAGE.name, Navigation.SIGN_IN.name)
            }.onFailure {
                Log.e(TAG, "onSignInClick: ", it)
            }
        }
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit){
        viewModelScope.launch {
            runCatching {
                accountService.signUp(email.value, password.value)
                openAndPopUp(Navigation.SIGN_IN.name, Navigation.SIGN_UP.name)
            }.onFailure {
                Log.e(TAG, "onSignInClick: ", it)
            }
        }
    }
}