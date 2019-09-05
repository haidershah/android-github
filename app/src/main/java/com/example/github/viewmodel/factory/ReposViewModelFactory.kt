package com.example.github.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.github.viewmodel.ReposViewModel
import java.lang.IllegalArgumentException

class ReposViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)) {
            return ReposViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
