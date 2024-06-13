package br.com.ourtrip.app.network.destinations

import retrofit2.http.GET

interface DestinationService {
    @GET("product")
    suspend fun findDestinations(): List<Destinations>
}
