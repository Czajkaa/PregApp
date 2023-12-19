package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val button1 = findViewById<Button>(R.id.page2_button1)
        button1.setOnClickListener{
            val page15 = Intent(applicationContext, page_15::class.java)
            startActivity(page15)
        }
    }
}