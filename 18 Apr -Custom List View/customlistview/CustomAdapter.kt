package com.bmpl.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// :

class CustomAdapter(mainActivity: MainActivity, imagesArray: Array<Int>, contactsNameArray: Array<String>) : BaseAdapter()
{

    var images : Array<Int> = imagesArray
    var contacts : Array<String> = contactsNameArray
    var activity = mainActivity
    // LayoutInflater -->
    //getSystemService
    // as --> lambda function in kotlin
    // button.setOnClickListener{ logic }
    var layoutInflater : LayoutInflater = mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //CustomAdapter(){} // default cons
    // p0 --> 0 , p0--> 1
    override fun getView(index: Int, p1: View?, viewGroup: ViewGroup?): View {

        //setContentView(R.layout.custom_layout)  // Activity class

        var view : View = layoutInflater.inflate(R.layout.custom_layout, null)

        var image = activity.findViewById<ImageView>(R.id.imageView)
        var textView = view.findViewById<TextView>(R.id.nameTextView)

        image.setImageResource(images[index])   // 2<array.size
        textView.text = contacts[index] // 2


        return view
    }

    override fun getItem(index: Int): Any {
        return images[index]   // 0 < images.size
    }

    override fun getItemId(p0: Int): Long {
        return images[p0].toLong()
    }

    // return the total no. of data which is going to be displayed on the screen

    //
    override fun getCount(): Int {
        return images.size // will start with 1
    }
}