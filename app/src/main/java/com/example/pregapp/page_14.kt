package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class page_14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page14)

        val icon1 = findViewById<ImageButton>(R.id.page14_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page14_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page14_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page14_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }

        val button1 = findViewById<Button>(R.id.page14_button1)
        button1.setOnClickListener{
            val page16 = Intent(applicationContext, page_16::class.java)
            startActivity(page16)
        }
        val button2 = findViewById<Button>(R.id.page14_button2)
        button2.setOnClickListener{
            val page1 = Intent(applicationContext, page_1::class.java)
            startActivity(page1)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}