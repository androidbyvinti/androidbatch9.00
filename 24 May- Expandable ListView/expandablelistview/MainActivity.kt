package com.bmpl.expandablelistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ExpandableListView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var listAdapter: ExpandableListAdapter
    lateinit var listDataHeader: ArrayList<String>
    lateinit var listDataChild: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareListData()

        listAdapter = ExpandableListAdapter(this, listDataHeader, listDataChild)


        .setAdapter(listAdapter)

        expListView.setOnGroupClickListener { parent, v, groupPosition, id ->
            // Toast.makeText(getApplicationContext(),
            // "Group Clicked " + listDataHeader.get(groupPosition),
            // Toast.LENGTH_SHORT).show();
            false
        }

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(applicationContext,
                    listDataHeader[groupPosition] + " Expanded",
                    Toast.LENGTH_SHORT).show()
        }

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(applicationContext,
                    listDataHeader[groupPosition] + " Collapsed",
                    Toast.LENGTH_SHORT).show()
        }

        // Listview on child click listener
        expListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            // TODO Auto-generated method stub
            Toast.makeText(
                    applicationContext,
                    listDataHeader[groupPosition]
                            + " : "
                            + listDataChild[listDataHeader[groupPosition]]!![childPosition], Toast.LENGTH_SHORT)
                    .show()
            false
        }
    }

    /*
     * Preparing the list data
     */
    private fun prepareListData() {
        listDataHeader = ArrayList()
        listDataChild = HashMap()

        // Adding child data
        listDataHeader.add("Top 250")
        listDataHeader.add("Now Showing")
        listDataHeader.add("Coming Soon..")

        // Adding child data
        val data1 = ArrayList<String>()
        data1.add("Sub Data 1.1")
        data1.add("Sub Data 1.2")
        data1.add("Sub Data 1.3")
        data1.add("Sub Data 1.4")
        data1.add("Sub Data 1.5")
        data1.add("Sub Data 1.6")
        data1.add("Sub Data 1.7")

        val nowShowing = ArrayList<String>()
        nowShowing.add("The Conjuring")
        nowShowing.add("Despicable Me 2")
        nowShowing.add("Turbo")
        nowShowing.add("Grown Ups 2")
        nowShowing.add("Red 2")
        nowShowing.add("The Wolverine")

        val comingSoon = ArrayList<String>()
        comingSoon.add("2 Guns")
        comingSoon.add("The Smurfs 2")
        comingSoon.add("The Spectacular Now")
        comingSoon.add("The Canyons")
        comingSoon.add("Europa Report")

        listDataChild.put(listDataHeader.get(0), language) // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing)
        listDataChild.put(listDataHeader.get(2), comingSoon)
    }
}