package com.example.jpmchase

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel

class ArcViewModel:ViewModel() {
    var TAG = ArcViewModel::class.java.simpleName

    var  counter = 0
    lateinit var timer: CountDownTimer
    var _seconds = 0

    fun incrementCount() {
        counter++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemainning: Long) {
                _seconds = timeRemainning.toInt()
                Log.i(TAG,"seconds value ="+_seconds)
            }

            override fun onFinish() {
                Log.i(TAG,"timer finnished")
            }

        }.start()
    }


}