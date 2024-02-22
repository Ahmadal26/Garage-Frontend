package com.joincoded.bankapi.network

import com.joincoded.bankapi.data.Login
import com.joincoded.bankapi.data.ProfileInfo
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GarageApiService {

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<TokenResponse>

    @POST(Constants.signinEndpoint)
    suspend fun signin(@Body user: Login): Response<TokenResponse>

    @GET("account")
    suspend fun getProfileInfo():List<ProfileInfo>





}