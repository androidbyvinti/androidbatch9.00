package com.bmpl.timer

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CountDownTimer
                                            // 20000 --> sec --> 20 --> 1000 milliseconds --> 1 sec
        // class inherit CountDownTimer
        var countDownTimer = object : CountDownTimer(20100, 1000){

            //
            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Times Up", Toast.LENGTH_SHORT).show()
            }
            // 1 sec ---> will work
            override fun onTick(p0: Long) {
                timerTextView.text = (p0/1000).toString() // 19100/1000 --> 19
            }

        }

        countDownTimer.start()  // will start the timer
    }
}
