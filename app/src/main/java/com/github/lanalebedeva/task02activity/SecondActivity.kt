package com.github.lanalebedeva.task02activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle = intent.extras
        val number = bundle?.getInt(MainActivity.NUMBER) ?: 0
        val textView = findViewById<TextView>(R.id.tv_secondActivity_number)
        textView.text = (number * number).toString()
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            TAG,
            "callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )
    }

    override fun onStart() {
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            MainActivity.TAG,
            "callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )
        super.onStart()
    }

    override fun onResume() {
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            TAG,
            "callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )
        super.onResume()
    }

    override fun onPause() {
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            TAG,
            "callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )
        super.onPause()
    }

    override fun onStop() {
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            TAG,
            "callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )
        super.onStop()
    }

    override fun onDestroy() {
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            TAG,
            "callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )
        super.onDestroy()
    }
    companion object {
        const val TAG = "SecondActivity"
    }
}
