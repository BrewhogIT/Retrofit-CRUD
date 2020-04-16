package com.brewhog.android.retrofit_crud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.brewhog.android.retrofit_crud.R
import com.brewhog.android.retrofit_crud.databinding.ActivityMainBinding
import com.brewhog.android.retrofit_crud.util.BookAdapter
import com.brewhog.android.retrofit_crud.viewmodel.BookViewModel
import com.brewhog.android.retrofit_crud.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = BookAdapter(listOf())
        val factory = ViewModelFactory(application)
        val viewModel = ViewModelProvider(this,factory).get(BookViewModel::class.java)

        viewModel.liveData.observe(this, Observer {
            adapter.updateBookList(it)
        })

        val mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        mainBinding.adapter = adapter
        mainBinding.viewModel = viewModel
    }
}
