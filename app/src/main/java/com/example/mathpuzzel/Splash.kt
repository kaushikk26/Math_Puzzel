package com.example.mathpuzzel

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.fonts.Font
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class Splash : AppCompatActivity() {

    lateinit var logo_splash: ImageView

    companion object {
        lateinit var sp: SharedPreferences
        lateinit var edit: SharedPreferences.Editor
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        logo_splash = findViewById(R.id.logo_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@Splash, FrontPage::class.java))
            finish()
        }, 2000)


    }
}