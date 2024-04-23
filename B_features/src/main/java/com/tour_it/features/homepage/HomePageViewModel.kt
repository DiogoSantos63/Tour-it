package com.tour_it.features.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.navigation.NavigationItem
import kotlinx.coroutines.launch

class HomePageViewModel(
    private val accountService: AccountService
) : ViewModel(){

    fun initialize(restartApp: (String) -> Unit){
        viewModelScope.launch {
            runCatching {
                accountService.currentUser.collect { user ->
                    if(user == null) restartApp(NavigationItem.SplashScreen.route)
                }
            }
        }
    }
}