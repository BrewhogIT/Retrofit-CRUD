package com.brewhog.android.retrofit_crud.api

import com.brewhog.android.retrofit_crud.model.Book
import retrofit2.Call
import retrofit2.http.*

interface BookInterface {
    @GET("/api/books/")
    fun getAllBooks () : Call<List<Book>>

    //or add @Path and {id}
    @GET("/api/books/")
    fun getBookByID(@Query("id")id : Int) : Call<Book>

    @POST("/api/books/create")
    fun addNewBook(@Body book: Book)

    @DELETE("/api/books")
    fun deleteBook (@Query("id") id : Int)

    @PUT("/api/books")
    fun updateBook(@Query("id") @Body book : Book)

}