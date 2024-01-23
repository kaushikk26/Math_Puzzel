package com.example.mathpuzzel

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FrontPage : AppCompatActivity() {
    companion object {
        lateinit var sp: SharedPreferences
        lateinit var edit: SharedPreferences.Editor
        var lock = "lock"
        var skip= "skip"
        var complete = "complete"
        var level2=0
    }

    lateinit var continuee: TextView
    lateinit var puzzeles: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.front_page)

        sp = getSharedPreferences("num", MODE_PRIVATE)
        edit = sp.edit()

        for (i in 1..75) {
            edit.putString("mylevel$i", sp.getString("mylevel$i", lock))
            edit.apply()
        }

        level2=sp.getInt("mylevel",0)

        continuee = findViewById(R.id.continuee)
        puzzeles = findViewById(R.id.puzzels)

        continuee.setOnClickListener {

            var intent = Intent(this@FrontPage, PuzzelePage::class.java).putExtra("level22",level2)
            startActivity(intent)
        }

        puzzeles.setOnClickListener {
            var puzzeles1 = Intent(this@FrontPage, Puzzeles::class.java)
            startActivity(puzzeles1)
        }
    }
}