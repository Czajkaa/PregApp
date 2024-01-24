package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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

    @SuppressLint("SetTextI18n")
    private fun addSpasm(number: Int) {
        val text1 = findViewById<TextView>(R.id.page22_text1)
        val text2 = findViewById<TextView>(R.id.page22_text2)
        val linearLayout = findViewById<LinearLayout>(R.id.page22_linearLayout)
        val scrollView = findViewById<ScrollView>(R.id.page22_scrollView)
        val border2 = findViewById<View>(R.id.page22_border2)
        val buttonText1 = findViewById<TextView>(R.id.page22_text4)
        val button1 = findViewById<ImageButton>(R.id.page22_image2)

        val line1 = findViewById<TextView>(R.id.page22_line1)
        val line2 = findViewById<TextView>(R.id.page22_line2)
        val line3 = findViewById<TextView>(R.id.page22_line3)
        val line4 = findViewById<TextView>(R.id.page22_line4)
        val line5 = findViewById<TextView>(R.id.page22_line5)
        val line6 = findViewById<TextView>(R.id.page22_line6)

        val time1 = findViewById<TextView>(R.id.page22_time1)
        val time2 = findViewById<TextView>(R.id.page22_time2)
        val time3 = findViewById<TextView>(R.id.page22_time3)
        val time4 = findViewById<TextView>(R.id.page22_time4)
        val time5 = findViewById<TextView>(R.id.page22_time5)
        val time6 = findViewById<TextView>(R.id.page22_time6)

        val delay1 = findViewById<TextView>(R.id.page22_delay1)
        val delay2 = findViewById<TextView>(R.id.page22_delay2)
        val delay3 = findViewById<TextView>(R.id.page22_delay3)
        val delay4 = findViewById<TextView>(R.id.page22_delay4)
        val delay5 = findViewById<TextView>(R.id.page22_delay5)

        when (number) {
            1 -> {
                text1.visibility = View.GONE
                text2.visibility = View.GONE
                buttonText1.text = getString(R.string.page22_text4_2)
                linearLayout.visibility = View.VISIBLE
                scrollView.visibility = View.VISIBLE
                border2.visibility = View.VISIBLE
                line1.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            2 -> {
                time1.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            3 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line2.text = ((number+1)/2).toString()
                delay1.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            4 -> {
                time2.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            5 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line3.text = ((number+1)/2).toString()
                delay2.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            6 -> {
                time3.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            7 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line4.text = ((number+1)/2).toString()
                delay3.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            8 -> {
                time4.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            9 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line5.text = ((number+1)/2).toString()
                delay4.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            10 -> {
                time5.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            11 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line6.text = ((number+1)/2).toString()
                delay5.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            12 -> {
                time6.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            13 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                button1.setImageResource(R.drawable.page10_image1_2)
                line1.text = ((number+1)/2).toString()
                line2.text = ""
                line3.text = ""
                line4.text = ""
                line5.text = ""
                line6.text = ""
                time1.visibility = View.INVISIBLE
                time2.visibility = View.INVISIBLE
                time3.visibility = View.INVISIBLE
                time4.visibility = View.INVISIBLE
                time5.visibility = View.INVISIBLE
                time6.visibility = View.INVISIBLE
                delay1.visibility = View.INVISIBLE
                delay2.visibility = View.INVISIBLE
                delay3.visibility = View.INVISIBLE
                delay4.visibility = View.INVISIBLE
                delay5.visibility = View.INVISIBLE
            }
            14 -> {
                time1.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            15 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line2.text = ((number+1)/2).toString()
                delay1.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            16 -> {
                time2.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            17 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line3.text = ((number+1)/2).toString()
                delay2.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            18 -> {
                time3.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            19 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line4.text = ((number+1)/2).toString()
                delay3.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            20 -> {
                time4.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            21 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line5.text = ((number+1)/2).toString()
                delay4.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            22 -> {
                time5.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            23 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line6.text = ((number+1)/2).toString()
                delay5.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)
            }
            24 -> {
                time6.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
            25 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                button1.setImageResource(R.drawable.page10_image1_2)
                line1.text = ((number+1)/2).toString()
                line2.text = ""
                line3.text = ""
                line4.text = ""
                line5.text = ""
                line6.text = ""
                time1.visibility = View.INVISIBLE
                time2.visibility = View.INVISIBLE
                time3.visibility = View.INVISIBLE
                time4.visibility = View.INVISIBLE
                time5.visibility = View.INVISIBLE
                time6.visibility = View.INVISIBLE
                delay1.visibility = View.INVISIBLE
                delay2.visibility = View.INVISIBLE
                delay3.visibility = View.INVISIBLE
                delay4.visibility = View.INVISIBLE
                delay5.visibility = View.INVISIBLE
            }
            26 -> {
                time1.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}