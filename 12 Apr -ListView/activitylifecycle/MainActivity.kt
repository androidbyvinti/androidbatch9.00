package com.bmpl.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var values = arrayOf("Data 1", "Data 2", "Data 3",
                        "Data 4", "Data 5", "Data 6",
                        "Data 7", "Data 8", "Data 9",
                        "Data 10", "Data 11", "Data 12",
                        "Data 13", "Data 14", "Data 15")  // Array<Int>

    lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "inside onCreate")

        arrayAdapter = ArrayAdapter(this, R.layout.custom_layout, values)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { adapterView, view, index, l ->

            var intent = Intent(this, SecondActivity :: class.java) // kotlin class --> Intent --> java class
            intent.putExtra("data", values[index])  //
            startActivity(intent)

            //Toast.makeText(this, "You clicked on ${values[index]}", Toast.LENGTH_SHORT).show()

        }

    }

    // listeners setup
    override fun onStart() {
        super.onStart() // onStart()
        Log.i("MainActivity", "inside onStart")
    }


    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "inside onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "inside onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "inside onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "inside onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "inside onDestroy")
    }
}
