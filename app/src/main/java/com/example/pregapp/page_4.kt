package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page4)

        val button1 = findViewById<Button>(R.id.page4_button1)
        button1.setOnClickListener{
            val page5 = Intent(applicationContext, page_5::class.java)
            startActivity(page5)
        }
    }
}