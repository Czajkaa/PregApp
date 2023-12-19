package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class page_7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page7)

        val button1 = findViewById<ImageButton>(R.id.page7_button1)
        button1.setOnClickListener{
            val page8 = Intent(applicationContext, page_8::class.java)
            startActivity(page8)
        }
        val button2 = findViewById<ImageButton>(R.id.page7_button2)
        button2.setOnClickListener{
            Toast.makeText(this, resources.getString(R.string.toast1), Toast.LENGTH_LONG).show()
            val page1 = Intent(applicationContext, page_1::class.java)
            startActivity(page1)
        }
    }
}