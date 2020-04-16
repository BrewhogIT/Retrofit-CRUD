package com.brewhog.android.retrofit_crud.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory (val application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookViewModel::class.java)){
            return BookViewModel(application) as T
        }else{
            throw IllegalArgumentException("no one correct class")
        }
    }
}