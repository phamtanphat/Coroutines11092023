package com.example.coroutines11092023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
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
            // val jobA = launch { generateValueA() }
            // jobA.join()

            // val jobB = launch { generateValueB() }
            // jobB.join()
            // Log.d("BBB", "A va B finish")

//            val startTime = System.currentTimeMillis()
//            val job = launch {
//                var nextPrintTime = startTime
//                var i = 0
//                while (isActive) {
//                    if (System.currentTimeMillis() >= nextPrintTime) {
//                        log("job: I'm sleeping ${i++} ...")
//                        nextPrintTime += 500L
//                    }
//                }
//            }
//
//            delay(1300L) // delay a bit
//            log("main: I'm tired of waiting!")
//            job.cancel() // cancels the job
//            log("main: Now I can quit.")

            val job = launch {
                try {
                    repeat(1000) { i ->
                        log("I'm sleeping $i ...")
                        delay(500L)
                    }
                } finally {
                    // Tranh thủ close resource trong này đi nha :D
                    withContext(NonCancellable) {
                        delay(1000L)
                        log("I'm running finally")
                    }
                }
            }
            delay(1300L) // delay a bit
            log("main: I'm tired of waiting!")
            job.cancel() // cancels the job
            log("main: Now I can quit.")
        }
    }

    suspend fun generateValueA() {
        delay(2000)
        Log.d("BBB", "A: ${Random().nextInt(10)}")
    }

    suspend fun generateValueB() {
        delay(1000)
        Log.d("BBB", "B: ${Random().nextInt(20)}")
    }

    fun log(message: String) {
        Log.d("BBB", message)
    }
}