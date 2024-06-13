package br.com.ourtrip.app.network

import br.com.ourtrip.app.network.destinations.DestinationService
import br.com.ourtrip.app.network.user.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:3000/"

    val destination_api: DestinationService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DestinationService::class.java)
    }

    val user_api: UserService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserService::class.java)
    }
}