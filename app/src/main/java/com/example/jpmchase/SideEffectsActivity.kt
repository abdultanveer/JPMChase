package com.example.jpmchase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpmchase.ui.theme.JPMChaseTheme

class SideEffectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JPMChaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Counter()
                }
            }
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
        Log.i("Counter", "count value ="+ count.value)
    }


    Button(onClick = { count.value++ }) {
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