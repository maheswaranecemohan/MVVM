package com.mphasis.mvvmapplication.ui.data
sealed class DataEvent{
    data class Login(val authToken: String): DataEvent()
}
