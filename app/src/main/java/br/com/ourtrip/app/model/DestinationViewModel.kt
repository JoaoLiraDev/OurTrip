package br.com.ourtrip.app.model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ourtrip.app.network.destinations.Destinations
import br.com.ourtrip.app.network.RetrofitInstance
import kotlinx.coroutines.launch

class DestinationViewModel: ViewModel() {
    private val _data = mutableStateOf<List<Destinations>>(emptyList())
    val data: State<List<Destinations>> = _data

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response = RetrofitInstance.destination_api.findDestinations()
                _data.value = response
            } catch (e: Exception) {
                Log.e("DestinationViewModel", "Exception: ${e.message}")
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }
}