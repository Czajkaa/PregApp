package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class page_10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page10)

        val button1 = findViewById<Button>(R.id.page10_button1)
        button1.setOnClickListener{
            val page17 = Intent(applicationContext, page_17::class.java)
            startActivity(page17)
        }

        val icon2 = findViewById<ImageButton>(R.id.page10_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page10_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page10_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page10_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}