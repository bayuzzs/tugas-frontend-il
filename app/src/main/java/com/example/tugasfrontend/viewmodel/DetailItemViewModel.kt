package com.example.tugasfrontend.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tugasfrontend.model.AppItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailItemViewModel: ViewModel(){
private val _selectedApp = MutableStateFlow<AppItem?>(null)
val selectedApp: StateFlow<AppItem?> = _selectedApp.asStateFlow()

    fun setSelectedApp(app: AppItem){
        _selectedApp.value = app
    }

    fun resetSelectedApp(){
        _selectedApp.value = null
    }

    fun getSelectedApp(): AppItem? {
        return _selectedApp.value
    }
}
