package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class page_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        val button1 = findViewById<ImageButton>(R.id.page3_button1)
        button1.setOnClickListener{
            val page4 = Intent(applicationContext, page_4::class.java)
            startActivity(page4)
        }
        val button2 = findViewById<ImageButton>(R.id.page3_button2)
        button2.setOnClickListener{
            val page5 = Intent(applicationContext, page_5::class.java)
            startActivity(page5)
        }
    }
}