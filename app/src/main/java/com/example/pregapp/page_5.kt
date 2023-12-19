package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class page_5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page5)

        val button1 = findViewById<ImageButton>(R.id.page5_button1)
        button1.setOnClickListener{
            val page6 = Intent(applicationContext, page_6::class.java)
            startActivity(page6)
        }
        val button2 = findViewById<ImageButton>(R.id.page5_button2)
        button2.setOnClickListener{
            val page7 = Intent(applicationContext, page_7::class.java)
            startActivity(page7)
        }
    }
}