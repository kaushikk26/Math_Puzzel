package com.example.mathpuzzel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class Puzzeles : AppCompatActivity() {

    var array= arrayOf("1","2","3","4","5", "6","7","8","9","10","11","12", "13","14","15","16",
        "17","18","19", "20","21","22","23","24","25","26", "27","28","29","30","31","32","33",
        "34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51"
        ,"52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69",
        "70","71","72","73","74","75")


    lateinit var gridview:GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puzzeles)

        gridview = findViewById(R.id.gridview)

        var adapter = Class1(this, array)

        gridview.adapter = adapter

        gridview.setOnItemClickListener { parent, view, positionn, id ->

            if (!FrontPage.sp.getString("mylevel$positionn", "an").equals(FrontPage.lock)) {
                val statpuzzle = Intent(this@Puzzeles, PuzzelePage::class.java).putExtra("level22", positionn)
                startActivity(statpuzzle)
            }


        }
    }
    }