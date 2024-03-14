package br.com.ourtrip.app.model

data class Destination(
    val id: Long = 0,
    val imageUrl: String = "",
    val destinationName: String = "",
    val starNumber: String = "",
    val destinationPrice: String = "",
    val description: String = ""
)
