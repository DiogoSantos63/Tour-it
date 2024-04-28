package com.tour_it.producer.navigation

import com.tour_it.producer.enums.Navigation

sealed class NavigationItem(val route: String){
    object Authentication: NavigationItem(Navigation.AUTHENTICATION.name)
    object SignInScreen: NavigationItem(Navigation.SIGN_IN.name)
    object SignUpScreen: NavigationItem(Navigation.SIGN_UP.name)
    object HomePage: NavigationItem(Navigation.HOME.name)
    object HomePageScreen: NavigationItem(Navigation.HOMEPAGE.name)
    object SplashScreen: NavigationItem(Navigation.SPLASH_SCREEN.name)
    object Splash: NavigationItem(Navigation.SPLASH.name)
    object Map: NavigationItem(Navigation.MAP.name)
    object MapScreen: NavigationItem(Navigation.MAP_SCREEN.name)
}