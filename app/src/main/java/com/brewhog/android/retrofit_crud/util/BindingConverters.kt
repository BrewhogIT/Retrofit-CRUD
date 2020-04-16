package com.brewhog.android.retrofit_crud.util

import androidx.databinding.BindingConversion

@BindingConversion
public fun intToString(int : Int) : String{
    return int.toString()
}