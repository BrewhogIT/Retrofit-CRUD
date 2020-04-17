package com.brewhog.android.retrofit_crud.util

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.brewhog.android.retrofit_crud.databinding.BookItemBinding
import com.brewhog.android.retrofit_crud.model.Book
import com.brewhog.android.retrofit_crud.view.BookActivity

class BookHolder(var bookItemBinding: BookItemBinding) : RecyclerView.ViewHolder(bookItemBinding.root), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        var book : Book? = bookItemBinding.book
        var bookID = book?.id
        var intent = Intent(p0?.context, BookActivity::class.java)
        intent.putExtra("bookID",bookID)
        p0?.context?.startActivity(intent)
    }

}