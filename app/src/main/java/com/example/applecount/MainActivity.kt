package com.example.applecount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applecount.ui.theme.AppleCountTheme
import com.example.applecount.AppleCountViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppleCountTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Yuka",
                        modifier = Modifier.padding(innerPadding)
                    )
                    AppleCount()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "★$name AppleCountApp!",
        modifier = modifier
    )
}

@Composable
fun AppleCount(
    modifier: Modifier = Modifier,
    viewModel: AppleCountViewModel = viewModel()
){
    val text = viewModel.text.value

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> viewModel.onTextChanged(newText) },
            label = { Text("りんごの数を入力してください") },
            modifier = Modifier.padding(16.dp),
            singleLine = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppleCountPreview() {
    AppleCount()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppleCountTheme {
        Greeting("Android")
    }
}