package com.mphasis.mvvmapplication.domain.data
sealed class UIComponent{
    data class Dialog(
        val title: String,
        val description: String,
    ): UIComponent()

    data class None(
        val message: String,
    ): UIComponent()
}