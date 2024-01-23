package com.example.mathpuzzel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class PuzzelePage : AppCompatActivity() {


    lateinit var puzzeleboard : TextView
    lateinit var levelboard : TextView
    lateinit var taxtview : TextView
    lateinit var delete : TextView
    lateinit var submit : TextView
    lateinit var skip :ImageView


    var array= arrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,
        R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,
        R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,
        R.drawable.p18,R.drawable.p19,R.drawable.p20,R.drawable.p21,R.drawable.p22,R.drawable.p23,
        R.drawable.p24,R.drawable.p25,R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p29,
        R.drawable.p30,R.drawable.p31, R.drawable.p32,R.drawable.p33,R.drawable.p34,R.drawable.p35,
        R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39,R.drawable.p40,R.drawable.p41,
        R.drawable.p42,R.drawable.p43,R.drawable.p44,R.drawable.p45,R.drawable.p46,R.drawable.p47,
        R.drawable.p48,R.drawable.p49,R.drawable.p50,R.drawable.p51,R.drawable.p52,R.drawable.p53,
        R.drawable.p54,R.drawable.p55,R.drawable.p56,R.drawable.p57,R.drawable.p58,R.drawable.p59,
        R.drawable.p60,R.drawable.p61,R.drawable.p62,R.drawable.p63,R.drawable.p64,R.drawable.p65,
        R.drawable.p66,R.drawable.p67,R.drawable.p68,R.drawable.p69,R.drawable.p70,R.drawable.p71,
        R.drawable.p72,R.drawable.p73,R.drawable.p74,R.drawable.p75)

//    var answer= arrayOf("10","25","6","14","128","7","50","1025","100","3","212","3011","14","","1","2","44",)

    var answer= arrayOf("1","2","3","4","5", "6","7","8","9","10","11","12", "13","14","15","16",
    "17","18","19", "20","21","22","23","24","25","26", "27","28","29","30","31","32","33",
    "34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51"
    ,"52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69",
    "70","71","72","73","74","75")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puzzelepage)

        taxtview=findViewById(R.id.taxtview)
        levelboard=findViewById(R.id.levelboard)


        var level2=intent.getIntExtra("level22",0)
        var check=level2

        levelboard.setText("Puzzele  "+(level2+1))

        var buttons = listOf<Button>(
            findViewById(R.id.one),
            findViewById(R.id.two),
            findViewById(R.id.three),
            findViewById(R.id.four),
            findViewById(R.id.five),
            findViewById(R.id.six),
            findViewById(R.id.seven),
            findViewById(R.id.eight),
            findViewById(R.id.nine),
            findViewById(R.id.zero)
        )

        for (button in buttons){
            button.setOnClickListener {
                taxtview.setText(taxtview.text.toString()+button.text.toString())

            }
        }
        delete=findViewById(R.id.delet)
        delete.setOnClickListener{
            try {
                taxtview.setText(taxtview.text.substring(0, taxtview.text.length - 1))
            }
            catch (k: StringIndexOutOfBoundsException) {

            }
        }

        puzzeleboard=findViewById(R.id.puzzeleboard)
        submit=findViewById(R.id.submit)

        puzzeleboard.setBackgroundResource(array[level2])

        submit.setOnClickListener {
            if(answer[level2]==taxtview.text){


                if(FrontPage.sp.getString("mylevel${level2+1}","ab").equals(FrontPage.skip)) {


                    FrontPage.edit.putString("mylevel$level2", FrontPage.complete)
                    FrontPage.edit.apply()
                    check++


                    var intent = Intent(this@PuzzelePage, Levelcomplitedpage::class.java)
                    startActivity(intent.putExtra("level2", check))

                }
                else if(FrontPage.sp.getString("mylevel${level2+1}","ab").equals(FrontPage.complete))
                {
                    check++
                    var intent = Intent(this@PuzzelePage, Levelcomplitedpage::class.java)
                    startActivity(intent.putExtra("level2", check))

                }
                else if(FrontPage.sp.getString("mylevel${level2+1}","ab").equals(FrontPage.lock))
                {
                    level2++

                    FrontPage.edit.putString("mylevel$level2", FrontPage.complete)
                    FrontPage.edit.apply()

                    FrontPage.edit.putInt("mylevel", level2)
                    FrontPage.edit.apply()

                    var intent = Intent(this@PuzzelePage, Levelcomplitedpage::class.java)
                    startActivity(intent.putExtra("level2", level2))

                    finish()
                }
            }
        }
        skip=findViewById(R.id.skip)
        skip.setOnClickListener {
            level2++
            FrontPage.edit.putString("mylevel$level2",FrontPage.skip)
            FrontPage.edit.apply()
            FrontPage.edit.putInt("mylevel",level2)
            FrontPage.edit.apply()
            var intent=Intent(this@PuzzelePage,PuzzelePage::class.java)
            startActivity(intent.putExtra("level22",level2))

            finish()
        }
    }
}