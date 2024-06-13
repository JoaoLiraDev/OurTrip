package br.com.ourtrip.app.model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ourtrip.app.network.RetrofitInstance
import br.com.ourtrip.app.network.user.CreateUser
import br.com.ourtrip.app.network.user.Login
import br.com.ourtrip.app.network.user.User
import br.com.ourtrip.app.network.user.UserToken
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel: ViewModel() {
    private val _response = mutableStateOf<UserToken?>(null)
    val response: State<UserToken?> = _response

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val user = Login(email, password)
                val result: Response<UserToken> = RetrofitInstance.user_api.login(user)

                if (result.isSuccessful) {
                    _response.value = result.body()
                    Log.d("LoginViewModel", "User logged: ${result.body()}")
                } else {
                    Log.d("LoginViewModel", "Failed to login user: ${result.errorBody()?.string()}")
                    _response.value = null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("LoginViewModel", "Exception: ${e.message}")
                _response.value = null
            } finally {
                _loading.value = false
            }
        }
    }
}