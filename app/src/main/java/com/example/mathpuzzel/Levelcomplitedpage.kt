package com.example.mathpuzzel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Levelcomplitedpage : AppCompatActivity() {

    lateinit var winningtext: TextView
    lateinit var winningcontinue: Button
    lateinit var mainmanu: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levelcomplitedpage)

        winningtext = findViewById(R.id.winnigtext)
        var winning = intent.getIntExtra("level2", 0)

        winningtext.setText("Puzzele  " + winning + "  Complited")

        winningcontinue = findViewById(R.id.winnigcontinue)

        winningcontinue.setOnClickListener {


            var returnpuzzelpzge = Intent(this@Levelcomplitedpage, PuzzelePage::class.java).putExtra("level22",winning)
            startActivity(returnpuzzelpzge)
            finish()
        }

        mainmanu = findViewById(R.id.mainmanu)
        mainmanu.setOnClickListener {
            var manu = Intent(this@Levelcomplitedpage, FrontPage::class.java)
            startActivity(manu)
            finish()
        }
    }
}