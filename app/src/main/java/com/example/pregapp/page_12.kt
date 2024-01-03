package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class page_12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page12)

        val button1 = findViewById<ImageButton>(R.id.page12_image2)
        button1.setOnClickListener{
            val page24 = Intent(applicationContext, page_24::class.java)
            startActivity(page24)
        }

        val icon1 = findViewById<ImageButton>(R.id.page12_icon1)
        icon1.setOnClickListener {
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page12_icon2)
        icon2.setOnClickListener {
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon4 = findViewById<ImageButton>(R.id.page12_icon4)
        icon4.setOnClickListener {
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page12_icon5)
        icon5.setOnClickListener {
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}