package com.example.jpmchase

import android.util.Log
import com.example.jpmchase.SqlRepository.Companion.TAG
import com.example.jpmchase.di.LoggerService
import javax.inject.Inject

interface UserRepository{
    fun saveUser(email:String,password:String)
}

class SqlRepository @Inject constructor():UserRepository {

    override fun saveUser(email:String, password:String){
        Log.d(TAG,"user  saved  in sql db")
    }

    companion object{
        var TAG = "UserRepository"
    }
}

class FirebaseRepository :UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d(TAG,"user  saved  in firebase db")
    }

}