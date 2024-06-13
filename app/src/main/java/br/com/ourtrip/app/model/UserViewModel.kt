package br.com.ourtrip.app.model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ourtrip.app.network.user.CreateUser
import br.com.ourtrip.app.network.user.User
import br.com.ourtrip.app.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel: ViewModel() {
    private val _response = mutableStateOf<User?>(null)
    val response: State<User?> = _response

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    fun createUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val user = CreateUser(name, email, password)
                val result: Response<User> = RetrofitInstance.user_api.createUser(user)

                if (result.code() == 201) {
                    _response.value = result.body()
                    Log.d("UserViewModel", "User created: ${result.body()}")
                } else {
                    Log.d("UserViewModel", "Failed to create user: ${result.errorBody()?.string()}")
                    _response.value = null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("UserViewModel", "Exception: ${e.message}")
                _response.value = null
            } finally {
                _loading.value = false
            }
        }
    }
}