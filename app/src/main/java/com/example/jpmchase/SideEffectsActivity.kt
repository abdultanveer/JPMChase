package com.example.jpmchase

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
                    DerivedState()
                }
            }
        }
    }
}


@Composable
fun DerivedState(){
    val tableof = remember {
        mutableStateOf(5)
    }
    val index = produceState(initialValue = 0, ) {
        repeat(9){
            delay(1000)
            value +=1
        }
    }
//derived state ie message updates/recomposes when the source state ie  index changes/updates
    val  message = remember {
        derivedStateOf {
            "${tableof.value} * ${index.value}  = ${tableof.value * index.value}"
        }
    }

    Box {
        Text(text = message.value)
    }


}

@Composable
fun Counters(){
    val state = produceState(initialValue = 0) {
        for (i in 1..10){
            delay(1000)
            value++
        }
    }
//        remember {
//        mutableStateOf(0)
//    }
//
//    LaunchedEffect(Unit) {
//
//    }
    Text(text = state.value.toString(),
        style = MaterialTheme.typography.bodySmall)
}




@Composable
fun MyMediaPlayerApp(){
    var state = remember { mutableStateOf(false) }
val context = LocalContext.current
    DisposableEffect(Unit) {

   val mediaPlayer  = MediaPlayer.create(context,R.raw.music)
        mediaPlayer.start()
        Log.i("Dispose","started")
        onDispose {
        mediaPlayer.stop()
            mediaPlayer.release()
            Log.i("Dispose","cleaning up- releasing resources")
        }

    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "change state")
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
    val state = rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 = state) {
        //LE runs in  initial composition / when the key changes
        //LE will not launch on recomposition
        Log.d("2nd  effect","2nd effect started--value --"+state.toString())
        delay(5000)
        Log.i("updated","updated state ="+state.toString())
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