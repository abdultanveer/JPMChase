package com.example.jpmchase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jpmchase.ui.theme.JPMChaseTheme

class DiceRollerActivity : ComponentActivity() {
    var TAG = DiceRollerActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var  receivedData = intent.extras?.getString("jpmkey")
        setContent {
            JPMChaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceWithButtonAndImage(
                      data = receivedData!!,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)

                    )
                }
            }
        }
    }

    override fun onStart() {  //visible
        super.onStart()
        //throw NullPointerException("crash demo")
        Log.i(TAG,"starting/visble - hatching egg")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"visible - waking")

    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG,"background - sleep")

    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG," - hibernating")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG," - purge")

    }
}



@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier,data:String) {
    var result by remember { mutableStateOf(1) }
//remember -- remeber the values after recomposition
    //state = observable data
//when -- switch case
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = data)
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    JPMChaseTheme {
       // DiceWithButtonAndImage()
    }
}