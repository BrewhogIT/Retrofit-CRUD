package com.brewhog.android.retrofit_crud.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brewhog.android.retrofit_crud.api.RetrofitClient
import com.brewhog.android.retrofit_crud.model.Book
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookViewModel(application: Application) : AndroidViewModel(application) {
    var liveData : MutableLiveData<List<Book>> = MutableLiveData()
    var book : ObservableField<Book> = ObservableField()
    var bookId = 0
    //var bookLiveData : MutableLiveData<Book> = MutableLiveData()
    private var context = application.applicationContext
    private val retrofitInterface = RetrofitClient().getBookInterface()

    private fun loadBookListFromServer(){
        retrofitInterface.getAllBooks().enqueue(object  : Callback<List<Book>>{
            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Toast.makeText(context,"Books loading was failed",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful){
                    liveData.postValue(response.body())
                }else{
                    Toast.makeText(context,"Books loading is unsuccessful",Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun loadBookByID(id:Int){
        retrofitInterface.getBookByID(id).enqueue(object : Callback<Book>{
            override fun onFailure(call: Call<Book>, t: Throwable) {
                Toast.makeText(context,"Book loading was failed",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                if (response.isSuccessful){
                    book.set(response.body())
                    //bookLiveData.postValue(response.body())
                    Toast.makeText(context,"Book loading is successful",Toast.LENGTH_LONG).show()

                }else{
                    Toast.makeText(context,"Book loading is unsuccessful",Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun addBook(book : Book){
        retrofitInterface.addNewBook(book).enqueue(object : Callback<Book>{
            override fun onFailure(call: Call<Book>, t: Throwable) {
                Toast.makeText(context,"Book wasn't add!",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                if (response.isSuccessful){
                    Toast.makeText(context,"Book was add successful!",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Unsuccessful!",Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun updateBook(id: Int, book : Book){
        retrofitInterface.updateBook(id,book).enqueue(object : Callback<Book>{
            override fun onFailure(call: Call<Book>, t: Throwable) {
                Toast.makeText(context,"Book wasn't update!",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                if (response.isSuccessful){
                    Toast.makeText(context,"Book was updated successful!",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Unsuccessful!",Toast.LENGTH_LONG).show()
                }
            }

        })
    }

    private fun deleteBook(id : Int){
        retrofitInterface.deleteBook(id).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(context,"Book wasn't delete!",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    Toast.makeText(context,response.body()?.string(),Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Unsuccessful!",Toast.LENGTH_LONG).show()
                }
            }

        })
    }

    fun showBookList(){
        loadBookListFromServer()
    }

    fun showBookInfo(id: Int){
        loadBookByID(id)
        bookId = id
    }

    fun deleteBook(){
        deleteBook(bookId)
    }

    fun addOrUpdateBook(){
        val targetBook = book.get()
        val targetId = targetBook?.id ?: 0

        if (targetId != 0){
            updateBook(targetId,targetBook!!)
        }else{
            addBook(targetBook!!)
        }
    }

}