package com.example.applecount
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppleCountViewModel : ViewModel(){

    private val _text = mutableStateOf("0")
    val text: State<String> = _text

    fun onTextChanged(newText: String) {
        _text.value = newText
    }

    fun getAppleCountMessage(): String {
        val count = _text.value.toIntOrNull()
        return if (count != null) {
            "リンゴの数は $count 個です。"
        } else {
            "正しい数を入力してください。"
        }
    }
}
