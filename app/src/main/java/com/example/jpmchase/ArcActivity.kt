package com.example.jpmchase


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class ArcActivity : AppCompatActivity() {
    lateinit var counterTextView: TextView

    lateinit var viewModel:ArcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arc)
        viewModel = ViewModelProvider(this)[ArcViewModel::class.java]

        counterTextView = findViewById(R.id.textViewcounter)

        counterTextView.setText(""+viewModel.counter)
    }

    fun handleClicks(view: View) {
       viewModel.startTimer()
        counterTextView.setText(""+viewModel._seconds)
    }
}