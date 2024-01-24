package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
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

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == user) {
                        if(i.child("UserData").key.toString() == "UserData") {
                            if(i.child("UserData").child("periodDate").exists()){
                                if(i.child("UserData").child("pragnet").value.toString() == "0") {
                                    val howPeriod = i.child("UserData").child("howPeriod").value.toString()
                                    val howCycle = i.child("UserData").child("howCycle").value.toString()
                                } else {
                                    PBlayout.visibility = View.GONE
                                }

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

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}