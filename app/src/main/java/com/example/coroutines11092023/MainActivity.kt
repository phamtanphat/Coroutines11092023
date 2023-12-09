package com.example.coroutines11092023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Coroutine context: Chua cac element de cau hinh cho 1 coroutine
        // 1-Job: Quyet dinh vong doi cua 1 coroutine
        // 2-Dispatchers: Quyet coroutine se chay tren luong nao
        // 3-CoroutineExceptionHandler: Hung loi cua coroutine
        // 4-CoroutineName: Dat ten cho coroutine

        // Coroutine scope: Tao ra pham vi de su dung coroutine

        // Dispatchers.IO: luong background
        CoroutineScope( CoroutineName("A") + Dispatchers.IO + CoroutineExceptionHandler() + Job())

    }
}