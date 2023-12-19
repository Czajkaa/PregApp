package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class page_9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page9)

        val button1 = findViewById<Button>(R.id.page9_button1)
        button1.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
    }
}