package com.example.github.viewmodel.factory

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.github.viewmodel.ReposViewModel
import java.lang.IllegalArgumentException

class ReposViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)) {
            return ReposViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
