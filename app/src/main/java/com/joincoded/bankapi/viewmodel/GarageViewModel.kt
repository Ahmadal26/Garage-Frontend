package com.joincoded.bankapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.bankapi.model.GarageBranch
import com.joincoded.bankapi.data.GarageRepo
import com.joincoded.bankapi.data.ProfileInfo
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.network.GarageApiService
import com.joincoded.bankapi.network.RetrofitHelper
import kotlinx.coroutines.launch

class GarageViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(GarageApiService::class.java)
    var token: TokenResponse? by mutableStateOf(null)
    val requests = mutableStateListOf<String>()

    fun addRequest(request: String) {
        requests.add(request)
    }



var profileInfo3 by mutableStateOf(listOf<ProfileInfo>())
    var currentSelectedGarage : GarageBranch? by mutableStateOf(null)

    fun signup(username: String, password: String, image: String = "") {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, image, null))
                token = response.body()


            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun signin(username: String, password: String, image: String = "") {
        viewModelScope.launch {
            try {
                val response = apiService.signin(User(username, password, null, null))
                token = response.body()
                println("singin $token")
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun garageList(): List<GarageBranch> {
        return GarageRepo.garageList
    }

}












