package com.example.exceptionincoroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /**
         * CASE 1
         * */

        /*val topLevelScope = CoroutineScope(SupervisorJob())

        val deferredResult = topLevelScope.async {
            throw RuntimeException("RuntimeException in async coroutine")
        }

        topLevelScope.launch {
            try {
                deferredResult.await()
            } catch (exception: Exception) {
                log("Handle $exception in try/catch")
            }
        }

        Thread.sleep(100)*/


        /**
         * CASE 2
         * */

        /*val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
            log("Handle $exception in CoroutineExceptionHandler")
        }

        val topLevelScope = CoroutineScope(SupervisorJob() + coroutineExceptionHandler)
        topLevelScope.launch {
            async {
                throw RuntimeException("RuntimeException in async coroutine")
            }
        }
        Thread.sleep(100)*/


        /**
         * CASE 3
         * */

        /*val topLevelScope = CoroutineScope(SupervisorJob())

        topLevelScope.launch {
            try {
                coroutineScope {
                    launch {
                        throw RuntimeException("RuntimeException in nested coroutine")
                    }
                }
            } catch (exception: Exception) {
                log("Handle $exception in try/catch")
            }
        }

        Thread.sleep(100)*/


        /**
         * CASE 4
         * */

        /*val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
            log("Handle $exception in CoroutineExceptionHandler")
        }

        val topLevelScope = CoroutineScope(Job())

        topLevelScope.launch {
            val job1 = launch {
                log("starting Coroutine 1")
            }

            supervisorScope {
                val job2 = launch(coroutineExceptionHandler) {
                    log("starting Coroutine 2")
                    throw RuntimeException("Exception in Coroutine 2")
                }

                val job3 = launch {
                    log("starting Coroutine 3")
                }
            }
        }

        Thread.sleep(100)*/

    }
}