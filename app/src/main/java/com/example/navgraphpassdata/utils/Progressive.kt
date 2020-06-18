package com.example.navgraphpassdata.utils

interface Progressive {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}