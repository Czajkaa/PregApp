package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page_15 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page15)

        val button1 = findViewById<Button>(R.id.page15_button1)
        button1.setOnClickListener{
            val page3 = Intent(applicationContext, page_3::class.java)
            startActivity(page3)
        }
    }
}