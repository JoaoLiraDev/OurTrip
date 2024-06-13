package br.com.ourtrip.app.network.user

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("users")
    suspend fun createUser(@Body user: CreateUser): Response<User>

    @POST("auth/login")
    suspend fun login(@Body user: Login): Response<UserToken>
}