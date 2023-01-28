package com.mphasis.mvvmapplication.domain.data

sealed class ProgressBarState{
    
    object Loading: ProgressBarState()
    
    object Idle: ProgressBarState()
}