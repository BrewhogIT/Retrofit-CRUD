package com.brewhog.android.retrofit_crud.model

data class Book(
    var id : Int,
    var title : String,
    var author : String,
    var description : String,
    var published : Int
) {
}