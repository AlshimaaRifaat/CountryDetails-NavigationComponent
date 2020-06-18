package com.example.navgraphpassdata.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navgraphpassdata.ui.countrys.CountrysViewModel

class MainViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountrysViewModel() as T
    }
}