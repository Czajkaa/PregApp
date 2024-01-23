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
import android.widget.Toolbar.LayoutParams

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
        val border1 = findViewById<View>(R.id.page22_border1)
        val border2 = findViewById<View>(R.id.page22_border2)
        val line1 = findViewById<TextView>(R.id.page22_line1)
        val second = findViewById<TextView>(R.id.page22_line2)
        val third = findViewById<TextView>(R.id.page22_line3)

        when (number) {
            1 -> {
                text1.visibility = View.GONE
                text2.visibility = View.GONE
                scrollView.visibility = View.VISIBLE
                line1.visibility = View.VISIBLE
            }

            2 -> {
                border2.visibility = View.VISIBLE
                second.visibility = View.VISIBLE
            }
            3 -> {
                val params0 = RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, number*75)
                border1.layoutParams = params0

                val params1 = RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                params1.setMargins(85, number*75-50, 85, 0)
                line1.layoutParams = params1


                val params2 = RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                params2.setMargins(90, number*75-50, 90, (number-2)*100+80/2)
                val params3 = RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                params3.setMargins(90, 90, 90, (number-2)*100+80)


                second.layoutParams = params2
                third.layoutParams = params3

                border2.visibility = View.VISIBLE
                second.visibility = View.VISIBLE
                third.visibility = View.VISIBLE
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}