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
    object Points: NavigationItem(Navigation.POINTS.name)
    object PointsScreen: NavigationItem(Navigation.POINTS_SCREEN.name)
    object Search: NavigationItem(Navigation.SEARCH.name)
    object SearchScreen: NavigationItem(Navigation.SEARCH_SCREEN.name)
    object Cart: NavigationItem(Navigation.CART.name)
    object CartScreen: NavigationItem(Navigation.CART_SCREEN.name)
    object Product: NavigationItem(Navigation.PRODUCT.name)
    object ProductScreenHotel: NavigationItem(Navigation.PRODUCT_SCREEN_HOTEL.name)
    object ProductScreenEvent: NavigationItem(Navigation.PRODUCT_SCREEN_EVENT.name)
    object ProductScreenRestaurant: NavigationItem(Navigation.PRODUCT_SCREEN_RESTAURANT.name)
    object Profile: NavigationItem(Navigation.PROFILE.name)
    object ProfileScreen: NavigationItem(Navigation.PROFILE_SCREEN.name)
}