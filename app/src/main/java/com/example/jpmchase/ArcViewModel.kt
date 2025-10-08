package com.example.jpmchase

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArcViewModel:ViewModel() {
    var TAG = ArcViewModel::class.java.simpleName

    var  counter = 0
    lateinit var timer: CountDownTimer
    var _seconds = MutableLiveData<Int>()
    //i madde seconds as observable

    fun incrementCount() {
//        viewModelScope.launch {
//            ///call a suspendable fun
//        }
        counter++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemainning: Long) {
                _seconds.value = timeRemainning.toInt()

                Log.i(TAG,"seconds value ="+_seconds)
            }

            override fun onFinish() {
                Log.i(TAG,"timer finnished")
            }

        }.start()
    }


}