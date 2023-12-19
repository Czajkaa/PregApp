package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class page_17 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page17)

        val button1 = findViewById<Button>(R.id.page17_button1)
        button1.setOnClickListener{
            val page18 = Intent(applicationContext, page_18::class.java)
            startActivity(page18)
        }
        val button2 = findViewById<Button>(R.id.page17_button2)
        button2.setOnClickListener{
            val page19 = Intent(applicationContext, page_19::class.java)
            startActivity(page19)
        }
        val button3 = findViewById<Button>(R.id.page17_button3)
        button3.setOnClickListener{
            val page20 = Intent(applicationContext, page_20::class.java)
            startActivity(page20)
        }

        val icon1 = findViewById<ImageButton>(R.id.page17_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page17_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page17_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page17_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page17_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }
}