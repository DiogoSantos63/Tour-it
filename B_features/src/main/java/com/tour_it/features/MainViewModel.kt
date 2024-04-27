package com.tour_it.features

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tour_it.datas.map.repos.mock.MockData
import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.navigation.NavigationItem
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"
class MainViewModel(
    private val accountService: AccountService,
    private val mockData: MockData
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadMockDataToDB(){
        viewModelScope.launch {
            mockData.insertEvents()
            mockData.insertHotels()
        }
    }

    fun onAppStart(openAndPopUp: (String, String) -> Unit){
        if(accountService.hasUser()){
            openAndPopUp(NavigationItem.HomePageScreen.route, NavigationItem.SplashScreen.route)
        } else {
            openAndPopUp(NavigationItem.SignInScreen.route, NavigationItem.SplashScreen.route)
        }
    }
}