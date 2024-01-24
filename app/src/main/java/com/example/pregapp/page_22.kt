package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.math.BigInteger
import java.security.MessageDigest
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.ArrayList
import java.util.Calendar


class page_22 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page22)

        auth = Firebase.auth


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
        val user = md5(auth.currentUser?.email.toString())
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

                updateCramps(time(), number.toString())
            }
            2 -> {
                time1.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time1, (number-1).toString(), (number).toString())
            }
            3 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line2.text = ((number+1)/2).toString()
                delay1.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay1, (number-1).toString(), (number).toString())
            }
            4 -> {
                time2.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time2, (number-1).toString(), (number).toString())
            }
            5 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line3.text = ((number+1)/2).toString()
                delay2.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay2, (number-1).toString(), (number).toString())
            }
            6 -> {
                time3.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time3, (number-1).toString(), (number).toString())
            }
            7 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line4.text = ((number+1)/2).toString()
                delay3.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay3, (number-1).toString(), (number).toString())
            }
            8 -> {
                time4.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time4, (number-1).toString(), (number).toString())
            }
            9 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line5.text = ((number+1)/2).toString()
                delay4.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay4, (number-1).toString(), (number).toString())
            }
            10 -> {
                time5.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time5, (number-1).toString(), (number).toString())
            }
            11 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line6.text = ((number+1)/2).toString()
                delay5.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay5, (number-1).toString(), (number).toString())
            }
            12 -> {
                time6.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time6, (number-1).toString(), (number).toString())
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

                updateCramps(time(), number.toString())
            }
            14 -> {
                time1.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time1, (number-1).toString(), (number).toString())
            }
            15 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line2.text = ((number+1)/2).toString()
                delay1.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay1, (number-1).toString(), (number).toString())
            }
            16 -> {
                time2.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time2, (number-1).toString(), (number).toString())
            }
            17 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line3.text = ((number+1)/2).toString()
                delay2.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay2, (number-1).toString(), (number).toString())
            }
            18 -> {
                time3.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time3, (number-1).toString(), (number).toString())
            }
            19 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line4.text = ((number+1)/2).toString()
                delay3.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay3, (number-1).toString(), (number).toString())
            }
            20 -> {
                time4.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time4, (number-1).toString(), (number).toString())
            }
            21 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line5.text = ((number+1)/2).toString()
                delay4.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay4, (number-1).toString(), (number).toString())
            }
            22 -> {
                time5.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time5, (number-1).toString(), (number).toString())
            }
            23 -> {
                buttonText1.text = getString(R.string.page22_text4_2)
                line6.text = ((number+1)/2).toString()
                delay5.visibility = View.VISIBLE
                button1.setImageResource(R.drawable.page10_image1_2)

                updateCramps(time(), number.toString())
                delayTime(user, delay5, (number-1).toString(), (number).toString())
            }
            24 -> {
                time6.visibility = View.VISIBLE
                buttonText1.text = getString(R.string.page22_text4_1)
                button1.setImageResource(R.drawable.page10_image1)

                updateCramps(time(), number.toString())
                delayTime(user, time6, (number-1).toString(), (number).toString())
            }
        }
    }

    private fun time(): Int {
        val currentDate = Calendar.getInstance()
        val minute = currentDate.get(Calendar.MINUTE)
        val second = currentDate.get(Calendar.SECOND)
        return (minute*60 + second)
    }

    private fun delayTime(hash: String, item: TextView, num1: String, num2: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == hash) {
                        if(i.child("Cramps").key.toString() == "Cramps") {
                            val timeValue1 = i.child("Cramps").child(num1).value.toString().toInt()
                            val timeValue2 = i.child("Cramps").child(num2).value.toString().toInt()

                            val minutes = (timeValue2-timeValue1)/60
                            val seconds = (timeValue2-timeValue1)%60
                            val time = if(minutes < 10 && seconds < 10) "0$minutes:0$seconds"
                            else if (minutes >= 10 && seconds < 10) "$minutes:0$seconds"
                            else if (minutes < 10 && seconds >= 10) "0$minutes:$seconds"
                            else "$minutes:$seconds"
                            item.text = time
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addListenerForSingleValueEvent(getdata)
    }

    private fun updateCramps(cramps: Int, number:String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("Cramps").child(number)
        database.setValue(cramps)
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}