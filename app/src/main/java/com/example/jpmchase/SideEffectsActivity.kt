package com.example.jpmchase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpmchase.ui.theme.JPMChaseTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SideEffectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JPMChaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   App()
                }
            }
        }
    }
}

@Composable
fun App(){
    var timer = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        timer.value = 10
    }
    Counter(timer.value)

}

@Composable
fun Counter(value:Int){
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.i("updated","updated state ="+value.toString())
    }
    Text(text =value.toString() )
}

@Composable
fun CoroutineScopeComposable(){
    var countr = remember {
        mutableStateOf(0)
    }
    var scope = rememberCoroutineScope()
    var text =   "counter is running ${countr.value}"
    if(countr.value == 10){
        text =  "counter stopped"
    }
    Column {
        Text(text = text)

        Button(onClick = {
           scope.launch {
               Log.i("coroutine composable","started")
               for (i in  1..10){
                   countr.value++
                   delay(1000)
           }
           }

        }) {
            Text(text = "start")
        }


    }
}

@Composable
fun Counter(){
    var count = remember {

        mutableStateOf(0)
    }

    var mkey = count.value  %3 == 0

    LaunchedEffect(key1 = mkey) {
        //fetchingData()
        Log.i("Counter", "count value ="+ count.value)
    }


    Button(onClick = {
        count.value++
    }) {
        Text(text = "Increment")
    }
}

@Composable
fun ListComposable(){
   val categoryState = remember {
       mutableStateOf(emptyList<String>())
   }
    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategories()
    }
    LazyColumn {
        items(categoryState.value){
            item -> Text(text = item)
        }
    }
}

fun fetchCategories():List<String>{
    return listOf("first","second","third")
}


var counter = 1

@Composable
fun HasSideEffect(){
    counter++
    Text(text = "sideeffects"+ counter)
}