package com.bmpl.switchimage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        var clicked = false
//    // true
//        button.setOnClickListener {
//                        // (!false) --> true
//            clicked = !clicked
//                // !clicked  or clicked == false
//            if(!clicked){
//                button.text = resources.getString(R.string.hide_image)   // "1265656565".toString()
//                imageView.visibility = View.VISIBLE
//            }else{              // strings.xml --> res --> values
//                button.text = resources.getString(R.string.show_image)  // I18N --> Internationalization
//                imageView.visibility = View.INVISIBLE
//            }
//        }
        // if(true){}

    }
}