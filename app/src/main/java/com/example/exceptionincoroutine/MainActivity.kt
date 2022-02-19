package com.example.exceptionincoroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exceptionincoroutine.extention.log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/*
* https://www.lukaslechner.com/why-exception-handling-with-kotlin-coroutines-is-so-hard-and-how-to-successfully-master-it/
* */

class MainActivity : AppCompatActivity() {

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, exception ->
            log("Handle $exception in CoroutineExceptionHandler")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topLevelScope = CoroutineScope(Job())
        topLevelScope.launch(coroutineExceptionHandler) {
            try {
                launch {
                    throw RuntimeException("RuntimeException in nested coroutine")
                }
            } catch (exception: Exception) {
                log("Handle $exception")
            }
        }
        Thread.sleep(100)
    }

}