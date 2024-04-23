package com.tour_it.features

import androidx.lifecycle.ViewModel
import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.navigation.NavigationItem

const val TAG = "MainViewModel"
class MainViewModel(
    private val accountService: AccountService
) : ViewModel() {

    fun onAppStart(openAndPopUp: (String, String) -> Unit){
        if(accountService.hasUser()){
            openAndPopUp(NavigationItem.HomePageScreen.route, NavigationItem.SplashScreen.route)
        } else {
            openAndPopUp(NavigationItem.SignInScreen.route, NavigationItem.SplashScreen.route)
        }
    }
}