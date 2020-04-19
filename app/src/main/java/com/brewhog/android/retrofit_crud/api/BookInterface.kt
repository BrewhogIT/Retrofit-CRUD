package com.brewhog.android.retrofit_crud.api

import com.brewhog.android.retrofit_crud.model.Book
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface BookInterface {
    @GET("api/books/")
    fun getAllBooks () : Call<List<Book>>

    //or add @Path and {id}
    @GET("api/books/{id}")
    fun getBookByID(@Path("id")id : Int) : Call<Book>

    @POST("api/books/create")
    fun addNewBook(@Body book: Book) : Call<Book>

    @DELETE("api/books/{id}")
    fun deleteBook (@Path("id") id : Int) : Call<ResponseBody>

    @PUT("api/books/{id}")
    fun updateBook(@Path("id") id : Int, @Body book : Book) : Call<Book>

}