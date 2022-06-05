package xyz.teamgravity.material3demo.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        private const val HEART_CHECKED_DEFAULT = false
    }

    var heartChecked: Boolean by mutableStateOf(HEART_CHECKED_DEFAULT)
        private set

    fun onHeartCheckedChange() {
        heartChecked = !heartChecked
    }
}