package com.example.jpmchase

import android.util.Log
import com.example.jpmchase.di.LoggerService
import javax.inject.Inject

class UserRepository @Inject constructor(val loggerService: LoggerService) {

    fun saveUser(email:String,password:String){
       loggerService.log("user  saved  in db-loggerservice")
    }

    companion object{
        var TAG = "UserRepository"
    }
}