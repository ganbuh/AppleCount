package com.example.applecount

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applecount.ui.theme.AppleCountTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Button


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
        text = "★$name AppleCountApp!", color = MaterialTheme.colorScheme.primary,
        modifier = modifier
    )
}

@Composable
fun AppleCount(
    modifier: Modifier = Modifier,
    viewModel: AppleCountViewModel = viewModel()
){
    val text = viewModel.text.value
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> viewModel.onTextChanged(newText) },
            label = { Text("りんごの数を入力してください") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onClick = {
                val appleCountMessage = viewModel.getAppleCountMessage()
                Toast.makeText(context, appleCountMessage, Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("りんごの数を確認")
        }
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