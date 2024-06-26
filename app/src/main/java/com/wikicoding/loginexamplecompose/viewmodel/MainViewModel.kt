package com.wikicoding.loginexamplecompose.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wikicoding.loginexamplecompose.apiService.RetrofitService
import com.wikicoding.loginexamplecompose.models.Place
import com.wikicoding.loginexamplecompose.models.Token
import com.wikicoding.loginexamplecompose.models.User
import com.wikicoding.loginexamplecompose.repositories.AuthRepository
import com.wikicoding.loginexamplecompose.repositories.DbGraph
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(
    private val authRepository: AuthRepository = DbGraph.authRepository
) : ViewModel() {
    var tokenState by mutableStateOf("")
    var placesState = mutableStateOf(listOf<Place>())

    lateinit var getToken: Flow<Token>

    init {
        viewModelScope.launch {
            getToken = authRepository.getToken()
        }
    }

    fun login(user: User, callback: (Boolean) -> Unit) {
        val apiCallService = RetrofitService(tokenState).apiCallService

        viewModelScope.launch {
            try {
                val response = apiCallService.login(user)

                tokenState = response.token

                callback(true)
            } catch (e: HttpException) {
                Log.e("this error", e.message.toString())
                callback(false)
            }
        }
    }

    fun deleteToken() {
        val apiCallService = RetrofitService(tokenState).apiCallService

        viewModelScope.launch {
            try {
                val response = apiCallService.logout()
                Log.e("data_inside", response.toString()) // it's working!

                tokenState = ""
            } catch (e: HttpException) {
                Log.e("error", e.message.toString())
            }
        }
    }

    fun getPlaces() {
        val apiCallService = RetrofitService(tokenState).apiCallService

        viewModelScope.launch {
            try {
                val response = apiCallService.getPlaces()
                Log.e("data_inside", response.toString()) // it's working!

                placesState.value = response
            } catch (e: HttpException) {
                Log.e("error", e.message.toString())
            }
        }
    }
}