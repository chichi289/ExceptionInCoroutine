package com.example.exceptionincoroutine.extention

import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Chirag Prajapati on 19/02/22.
 * Space O Technologies
 * pchirag.spaceo@gmail.com
 */

fun AppCompatActivity.log(message: String) {
    Log.e("TAG",message)
}