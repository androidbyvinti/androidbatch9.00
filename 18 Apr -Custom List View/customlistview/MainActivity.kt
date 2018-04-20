package com.bmpl.customlistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var imagesArray  = arrayOf(R.drawable.profile, R.drawable.profile,
                                R.drawable.profile, R.drawable.profile,
                                R.drawable.profile, R.drawable.profile,
                                R.drawable.profile, R.drawable.profile,
                                R.drawable.profile, R.drawable.profile,
                                R.drawable.profile,R.drawable.profile) // Array<T>

    var contactsNameArray : Array<String> = arrayOf("Ram", "Mike",
                                    "Rohan", "Rahul",
                                    "Sohan", "Sonu",
                                    "Roy", "reena",
                                    "jason", "ravi",
                                    "riya", "karan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var layoutInflater = getSystemService()

        // ? --> optional --> either it contains null or either it contains a value
        var name : String? = null

        name = "Ram"

        var customAdapter = CustomAdapter(this, imagesArray, contactsNameArray) // object of CustomAdapter class

        listView.adapter = customAdapter

        //var mainActivity = MainActivity(this, 34)

    }
}
