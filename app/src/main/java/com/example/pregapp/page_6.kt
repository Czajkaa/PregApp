package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import java.math.BigInteger
import java.security.MessageDigest

class page_6 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page6)

        var howPeriod = 0
        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("howPeriod")

        val button13 = findViewById<Button>(R.id.page6_button13)
        button13.setOnClickListener{
            database.setValue(howPeriod.toString())
            val page7 = Intent(applicationContext, page_7::class.java)
            startActivity(page7)
        }

        val button1 = findViewById<Button>(R.id.page6_button1)
        val button2 = findViewById<Button>(R.id.page6_button2)
        val button3 = findViewById<Button>(R.id.page6_button3)
        val button4 = findViewById<Button>(R.id.page6_button4)
        val button5 = findViewById<Button>(R.id.page6_button5)
        val button6 = findViewById<Button>(R.id.page6_button6)
        val button7 = findViewById<Button>(R.id.page6_button7)
        val button8 = findViewById<Button>(R.id.page6_button8)
        val button9 = findViewById<Button>(R.id.page6_button9)
        val button10 = findViewById<Button>(R.id.page6_button10)
        val button11 = findViewById<Button>(R.id.page6_button11)
        val button12 = findViewById<Button>(R.id.page6_button12)

        button1.setOnClickListener{
            clearSelect()
            button1.isEnabled = false
            howPeriod = 1
        }
        button2.setOnClickListener{
            clearSelect()
            button2.isEnabled = false
            howPeriod = 2
        }
        button3.setOnClickListener{
            clearSelect()
            button3.isEnabled = false
            howPeriod = 3
        }
        button4.setOnClickListener{
            clearSelect()
            button4.isEnabled = false
            howPeriod = 4
        }
        button5.setOnClickListener{
            clearSelect()
            button5.isEnabled = false
            howPeriod = 5
        }
        button6.setOnClickListener{
            clearSelect()
            button6.isEnabled = false
            howPeriod = 6
        }
        button7.setOnClickListener{
            clearSelect()
            button7.isEnabled = false
            howPeriod = 7
        }
        button8.setOnClickListener{
            clearSelect()
            button8.isEnabled = false
            howPeriod = 8
        }
        button9.setOnClickListener{
            clearSelect()
            button9.isEnabled = false
            howPeriod = 9
        }
        button10.setOnClickListener{
            clearSelect()
            button10.isEnabled = false
            howPeriod = 10
        }
        button11.setOnClickListener{
            clearSelect()
            button11.isEnabled = false
            howPeriod = 11
        }
        button12.setOnClickListener{
            clearSelect()
            button12.isEnabled = false
            howPeriod = 12
        }
    }

    private fun clearSelect() {
        val button1 = findViewById<Button>(R.id.page6_button1)
        val button2 = findViewById<Button>(R.id.page6_button2)
        val button3 = findViewById<Button>(R.id.page6_button3)
        val button4 = findViewById<Button>(R.id.page6_button4)
        val button5 = findViewById<Button>(R.id.page6_button5)
        val button6 = findViewById<Button>(R.id.page6_button6)
        val button7 = findViewById<Button>(R.id.page6_button7)
        val button8 = findViewById<Button>(R.id.page6_button8)
        val button9 = findViewById<Button>(R.id.page6_button9)
        val button10 = findViewById<Button>(R.id.page6_button10)
        val button11 = findViewById<Button>(R.id.page6_button11)
        val button12 = findViewById<Button>(R.id.page6_button12)

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        button10.isEnabled = true
        button11.isEnabled = true
        button12.isEnabled = true
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}