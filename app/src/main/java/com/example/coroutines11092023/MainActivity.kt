package com.example.coroutines11092023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Kotlin la ngôn ngữ hỗ trợ xử lý đa luồng vì khi trình biên dịch vẫn đang sử dụng java
        // Có thể tham khảo sử dụng tạo luồng bằng Thread hoặc Coroutine

        // Coroutine context: Chua cac element de cau hinh cho 1 coroutine
        // 1-Job: Quyet dinh vong doi cua 1 coroutine
        // 2-Dispatchers: Quyet coroutine se chay tren luong nao
        // 3-CoroutineExceptionHandler: Hung loi cua coroutine
        // 4-CoroutineName: Dat ten cho coroutine

        // Coroutine scope: Tao ra pham vi de su dung coroutine
        // Dispatchers.IO: luong background
        CoroutineScope(Dispatchers.IO).launch {
            // Tao gia tri A
            // Tao gia tri B
            // Ket qua = A + B
            val valueA = generateValueA()
            val valueB = generateValueB()
            val result = valueA + valueB
            Log.d("pphat", result.toString())
        }
    }

    suspend fun generateValueA(): Int {
        delay(1000)
        return Random().nextInt(10)
    }

    suspend fun generateValueB(): Int {
        delay(1500)
        return Random().nextInt(10)
    }
}