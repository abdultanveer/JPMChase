package com.example.jpmchase.di

import android.util.Log
import javax.inject.Inject

class LoggerService @Inject constructor(){
    fun log(message:String){
        Log.d("loggerservice",message)
    }
}