package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView

class page_22 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page22)

        var number = 0
        val button1 = findViewById<ImageButton>(R.id.page22_image2)
        button1.setOnClickListener{
            number += 1
            addSpasm(number)
        }

        val icon1 = findViewById<ImageButton>(R.id.page22_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page22_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page22_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page22_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page22_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    private fun addSpasm(number: Int) {
        val text1 = findViewById<TextView>(R.id.page22_text1)
        val text2 = findViewById<TextView>(R.id.page22_text2)
        val scrollView = findViewById<ScrollView>(R.id.page22_scrollView)

        if(number == 1) {
            text1.visibility = View.GONE
            text2.visibility = View.GONE
            scrollView.visibility = View.VISIBLE

        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}