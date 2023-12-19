package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class page_20 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page20)

        val icon1 = findViewById<ImageButton>(R.id.page20_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page20_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page20_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page20_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page20_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }
}