package com.github.lanalebedeva.task02activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var numberView: TextView
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberView = findViewById<TextView>(R.id.tv_mainActivity_number)
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(NUMBER)
            ++number
        }
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        numberView.text = number.toString()
        Log.d(
            TAG,
            "callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )

        val buttonToSecondActivity = findViewById<Button>(R.id.btn_goToSecondActivity)
        buttonToSecondActivity.setOnClickListener{
            val intentToSecondActivity = Intent(this, SecondActivity::class.java).apply {
                putExtra(NUMBER, number)
            }
            startActivity(intentToSecondActivity)
        }
    }

    override fun onStart() {
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            TAG,
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

    override fun onSaveInstanceState(outState: Bundle) {
        val nameFunThread = Thread.currentThread().stackTrace[2].methodName
        Log.d(
            TAG,
            " callback: $nameFunThread; lifecycle.currentState.name: ${lifecycle.currentState.name}"
        )
        outState.putInt(NUMBER, number)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val NUMBER = "number"
        const val TAG = "mainActivity"
    }
}
