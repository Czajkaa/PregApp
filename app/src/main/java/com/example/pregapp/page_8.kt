package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class page_8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page8)

        val button1 = findViewById<Button>(R.id.page8_button1)
        button1.setOnClickListener{
            Toast.makeText(this, resources.getString(R.string.toast1), Toast.LENGTH_LONG).show()
            val page1 = Intent(applicationContext, page_1::class.java)
            startActivity(page1)
        }
    }
}