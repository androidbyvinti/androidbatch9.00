package com.bmpl.activitylifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var intent = intent
        //textviewid.text = intent.getStringExtra("data")
        Log.i("received data", intent.getStringExtra("data"))

    }
}
