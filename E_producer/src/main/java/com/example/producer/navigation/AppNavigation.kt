package com.example.producer.navigation

import com.example.producer.enums.Navigation

sealed class NavigationItem(val route: String){
    object Authentication: NavigationItem(Navigation.AUTHENTICATION.name)
    object LoginScreen: NavigationItem(Navigation.LOGIN.name)
    object Profile: NavigationItem(Navigation.PROFILE.name)
}