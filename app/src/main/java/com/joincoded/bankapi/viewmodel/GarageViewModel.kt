package com.joincoded.bankapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.bankapi.model.GarageBranch
import com.joincoded.bankapi.data.GarageRepo
import com.joincoded.bankapi.data.Login
import com.joincoded.bankapi.data.ProfileInfo
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.VehicleType
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.network.GarageApiService
import com.joincoded.bankapi.network.RetrofitHelper
import kotlinx.coroutines.launch

class GarageViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(GarageApiService::class.java)
    var token: TokenResponse? by mutableStateOf(null)
    val requests = mutableStateListOf<String>()


    var currentSelectedGarage: GarageBranch? by mutableStateOf(null)

    fun signup(
        username: String,
        password: String,
        email: String = "",
        vehicleType: VehicleType,
        vehicleYear: String,
        vehicleModel: String
    ) {
        viewModelScope.launch {
            try {
                val response = apiService.signup(
                    User(
                        username,
                        password,
                        email,
                        vehicleType,
                        vehicleYear,
                        vehicleModel,
                        null
                    )
                )
                token = response.body()


            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun signin(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = apiService.signin(Login(username, password))
                token = response.body()
                println("singin ${token?.token}")
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun garageList(): List<GarageBranch> {
        return GarageRepo.garageList
    }

   fun profilePage(){
       return
   }

}