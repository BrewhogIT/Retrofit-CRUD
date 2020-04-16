package com.brewhog.android.retrofit_crud.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.brewhog.android.retrofit_crud.databinding.BookItemBinding
import com.brewhog.android.retrofit_crud.model.Book

class BookHolder(var bookItemBinding: BookItemBinding) : RecyclerView.ViewHolder(bookItemBinding.root), View.OnClickListener {

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}