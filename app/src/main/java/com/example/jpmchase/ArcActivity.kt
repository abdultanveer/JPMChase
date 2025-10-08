package com.example.jpmchase


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ArcActivity : AppCompatActivity() {
    lateinit var counterTextView: TextView

    lateinit var viewModel:ArcViewModel


    var secsObserverphno: Observer<Int> = object : Observer<Int> {
        override fun onChanged(seconds: Int) {
            //receiving the update/notification
            counterTextView.setText(seconds.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arc)
        viewModel = ViewModelProvider(this)[ArcViewModel::class.java]


        viewModel._seconds.observe(this, secsObserverphno);

        counterTextView = findViewById(R.id.textViewcounter)

        counterTextView.setText(""+viewModel.counter)
    }

    fun handleClicks(view: View) {
       viewModel.startTimer()
        counterTextView.setText(""+viewModel._seconds)
    }

    fun startDialer(view: View) {
        //implicit intent -- since im not taking the name of the activity to be invoked
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"))
        startActivity(dIntent)
    }

    fun startDiceRolling(view: View) {
        //explicit intent == mentiooning the name of the activity to be invoked
        var diceIntent = Intent(this,DiceRollerActivity::class.java)
        diceIntent.putExtra("jpmkey","abdul")
        startActivity(diceIntent)
    }
}