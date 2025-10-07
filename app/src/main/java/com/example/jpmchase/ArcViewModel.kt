package com.example.jpmchase

import androidx.lifecycle.ViewModel

class ArcViewModel:ViewModel() {
    var  counter = 0

    fun incrementCount() {
        counter++
    }


}