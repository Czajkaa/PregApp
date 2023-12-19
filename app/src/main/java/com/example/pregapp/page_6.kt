package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page_6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page6)

        val button1 = findViewById<Button>(R.id.page6_button13)
        button1.setOnClickListener{
            val page7 = Intent(applicationContext, page_7::class.java)
            startActivity(page7)
        }
    }
}