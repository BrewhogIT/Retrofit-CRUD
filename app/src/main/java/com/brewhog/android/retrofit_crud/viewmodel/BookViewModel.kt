package com.brewhog.android.retrofit_crud.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brewhog.android.retrofit_crud.api.RetrofitClient
import com.brewhog.android.retrofit_crud.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookViewModel(application: Application) : AndroidViewModel(application) {
    var liveData : MutableLiveData<List<Book>> = MutableLiveData()
    var context = application.applicationContext
    
    fun loadBookListFromServer(){
        RetrofitClient().getBookInterface().getAllBooks().enqueue(object  : Callback<List<Book>>{
            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Toast.makeText(context,"Books loading was failed",Toast.LENGTH_LONG)
            }

            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful){
                    liveData.postValue(response.body())
                }
            }
        })
    }

    fun showBookList(){
        loadBookListFromServer()
    }
}