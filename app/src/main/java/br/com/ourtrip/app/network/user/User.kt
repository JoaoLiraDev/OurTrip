package br.com.ourtrip.app.network.user

import kotlin.reflect.KProperty

data class CreateUser(
    val name: String,
    val email: String,
    val password: String
)

data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: String,
    val updatedAt: String
)

data class Login (
    val email: String,
    val password: String,
)
data class UserToken(
    val access_token: String
)