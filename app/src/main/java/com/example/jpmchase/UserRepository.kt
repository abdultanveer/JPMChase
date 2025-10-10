package com.example.jpmchase

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun saveUser(email:String,password:String){
        Log.d(TAG,"user  saved  in db")
    }

    companion object{
        var TAG = UserRepository::class.java.simpleName
    }
}