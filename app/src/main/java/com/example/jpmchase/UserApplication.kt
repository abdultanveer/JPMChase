package com.example.jpmchase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class UserApplication:Application() {

//    @Inject
//    lateinit var userRepository: UserRepository
    //=  UserRepository()

    override fun onCreate() {
        super.onCreate()
       // userRepository.saveUser("abdul@mail.com","1234")
    }
}