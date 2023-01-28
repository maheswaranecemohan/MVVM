package com.mphasis.mvvmapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mphasis.mvvmapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UICommunicationListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun displayProgressBar(isLoading: Boolean) {
       System.out.println(isLoading)
    }
}