package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page_16 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page16)

        val button1 = findViewById<Button>(R.id.page16_button1)
        button1.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }
}