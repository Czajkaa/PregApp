package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Spinner
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
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Calendar

class page_12 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page12)

        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        date(user)

        val button1 = findViewById<ImageButton>(R.id.page12_image2)
        button1.setOnClickListener{
            val page24 = Intent(applicationContext, page_24::class.java)
            startActivity(page24)
        }

        val icon1 = findViewById<ImageButton>(R.id.page12_icon1)
        icon1.setOnClickListener {
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page12_icon2)
        icon2.setOnClickListener {
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon4 = findViewById<ImageButton>(R.id.page12_icon4)
        icon4.setOnClickListener {
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page12_icon5)
        icon5.setOnClickListener {
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    private fun date(user: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")

        val PBlayout = findViewById<RelativeLayout>(R.id.page12_PBlayout)
        val Tlayout = findViewById<LinearLayout>(R.id.page12_Tlayout)
        val dateLayout = findViewById<LinearLayout>(R.id.page12_dateLayout)
        val text1 = findViewById<TextView>(R.id.page13_text1)
        val button1 = findViewById<Button>(R.id.page12_button1)

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == user) {
                        if(i.child("UserData").key.toString() == "UserData") {
                            if (i.child("UserData").child("gender").value.toString() == "Kobieta") {
                                if(i.child("UserData").child("periodDate").exists()) {
                                    if(i.child("UserData").child("pragnet").value.toString() == "0") {
                                        val howPeriod = i.child("UserData").child("howPeriod").value.toString().toInt()
                                        val howCycle = i.child("UserData").child("howCycle").value.toString().toInt()
                                        val periodDate = i.child("UserData").child("periodDate").value.toString()
                                        calculateCycle (howPeriod, howCycle, periodDate)
                                    } else {
                                        PBlayout.visibility = View.GONE
                                        Tlayout.visibility = View.VISIBLE
                                    }
                                } else {
                                    PBlayout.visibility = View.GONE
                                    Tlayout.visibility = View.VISIBLE
                                    dateLayout.visibility = View.VISIBLE
                                    button1.visibility = View.VISIBLE
                                    text1.text = getString(R.string.page12_text8)
                                    button1.setOnClickListener{
                                        sendPeriodDate()
                                        dateLayout.visibility = View.GONE
                                        button1.visibility = View.GONE
                                        val page12 = Intent(applicationContext, page_12::class.java)
                                        startActivity(page12)
                                    }
                                }
                            } else {
                                PBlayout.visibility = View.GONE
                                Tlayout.visibility = View.VISIBLE
                                text1.text = getString(R.string.page13_text1_1)
                            }
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addListenerForSingleValueEvent(getdata)
    }

    private fun calculateCycle (howPeriod: Int, howCycle: Int, periodDate: String) {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH) + 1
        val day = currentDate.get(Calendar.DAY_OF_MONTH)
        val date = if(day < 10 && month < 10) "0$day/0$month/$year"
        else if (day >= 10 && month < 10) "$day/0$month/$year"
        else if (day < 10 && month >= 10) "0$day/$month/$year"
        else "$day/$month/$year"

        var cycle_level = 0
        var PMS_level = 0
        var period_level = 0

        val days = 5
        when(days) {
            in 0..(howCycle-howPeriod-2) -> {
                cycle_level = days*100/(howCycle-howPeriod-2)
            }
            in (howCycle-howPeriod-1)..(howCycle-howPeriod) -> {
                PMS_level = days*100/2
            }
            in (howCycle-howPeriod+1)..(howCycle) -> {
                period_level = days*100/howPeriod
            }
        }



    }

    private fun sendPeriodDate() {
        val dayInput = findViewById<Spinner>(R.id.page12_dropdown1)
        val monthInput = findViewById<Spinner>(R.id.page12_dropdown2)
        val yearInput = findViewById<Spinner>(R.id.page12_dropdown3)

        val day = dayInput.selectedItem.toString().toInt()
        val month = monthInput.selectedItem.toString().toInt()
        val year = yearInput.selectedItem.toString().toInt()

        val date = if(day < 10 && month < 10) "0$day/0$month/$year"
        else if (day >= 10 && month < 10) "$day/0$month/$year"
        else if (day < 10 && month >= 10) "0$day/$month/$year"
        else "$day/$month/$year"

        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("periodDate")
        database.setValue(date)
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}