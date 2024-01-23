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

class page_4 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page4)

        var howCycle = 0
        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("howCycle")

        val button1 = findViewById<Button>(R.id.page4_button1)
        button1.setOnClickListener{
            database.setValue(howCycle.toString())
            val page5 = Intent(applicationContext, page_5::class.java)
            startActivity(page5)
        }

        val button18 = findViewById<Button>(R.id.page4_button18)
        val button19 = findViewById<Button>(R.id.page4_button19)
        val button20 = findViewById<Button>(R.id.page4_button20)
        val button21 = findViewById<Button>(R.id.page4_button21)
        val button22 = findViewById<Button>(R.id.page4_button22)
        val button23 = findViewById<Button>(R.id.page4_button23)
        val button24 = findViewById<Button>(R.id.page4_button24)
        val button25 = findViewById<Button>(R.id.page4_button25)
        val button26 = findViewById<Button>(R.id.page4_button26)
        val button27 = findViewById<Button>(R.id.page4_button27)
        val button28 = findViewById<Button>(R.id.page4_button28)
        val button29 = findViewById<Button>(R.id.page4_button29)
        val button30 = findViewById<Button>(R.id.page4_button30)
        val button31 = findViewById<Button>(R.id.page4_button31)
        val button32 = findViewById<Button>(R.id.page4_button32)
        val button33 = findViewById<Button>(R.id.page4_button33)
        val button34 = findViewById<Button>(R.id.page4_button34)
        val button35 = findViewById<Button>(R.id.page4_button35)
        val button36 = findViewById<Button>(R.id.page4_button36)
        val button37 = findViewById<Button>(R.id.page4_button37)
        val button38 = findViewById<Button>(R.id.page4_button38)

        button18.setOnClickListener{
            clearSelect()
            button18.isEnabled = false
            howCycle = 18
        }
        button19.setOnClickListener{
            clearSelect()
            button19.isEnabled = false
            howCycle = 19
        }
        button20.setOnClickListener{
            clearSelect()
            button20.isEnabled = false
            howCycle = 20
        }
        button21.setOnClickListener{
            clearSelect()
            button21.isEnabled = false
            howCycle = 21
        }
        button22.setOnClickListener{
            clearSelect()
            button22.isEnabled = false
            howCycle = 22
        }
        button23.setOnClickListener{
            clearSelect()
            button23.isEnabled = false
            howCycle = 23
        }
        button24.setOnClickListener{
            clearSelect()
            button24.isEnabled = false
            howCycle = 24
        }
        button25.setOnClickListener{
            clearSelect()
            button25.isEnabled = false
            howCycle = 25
        }
        button26.setOnClickListener{
            clearSelect()
            button26.isEnabled = false
            howCycle = 26
        }
        button27.setOnClickListener{
            clearSelect()
            button27.isEnabled = false
            howCycle = 27
        }
        button28.setOnClickListener{
            clearSelect()
            button28.isEnabled = false
            howCycle = 28
        }
        button29.setOnClickListener{
            clearSelect()
            button29.isEnabled = false
            howCycle = 29
        }
        button30.setOnClickListener{
            clearSelect()
            button30.isEnabled = false
            howCycle = 30
        }
        button31.setOnClickListener{
            clearSelect()
            button31.isEnabled = false
            howCycle = 31
        }
        button32.setOnClickListener{
            clearSelect()
            button32.isEnabled = false
            howCycle = 32
        }
        button33.setOnClickListener{
            clearSelect()
            button33.isEnabled = false
            howCycle = 33
        }
        button34.setOnClickListener{
            clearSelect()
            button34.isEnabled = false
            howCycle = 34
        }
        button35.setOnClickListener{
            clearSelect()
            button35.isEnabled = false
            howCycle = 35
        }
        button36.setOnClickListener{
            clearSelect()
            button36.isEnabled = false
            howCycle = 36
        }
        button37.setOnClickListener{
            clearSelect()
            button37.isEnabled = false
            howCycle = 37
        }
        button38.setOnClickListener{
            clearSelect()
            button38.isEnabled = false
            howCycle = 38
        }
    }

    private fun clearSelect() {
        val button18 = findViewById<Button>(R.id.page4_button18)
        val button19 = findViewById<Button>(R.id.page4_button19)
        val button20 = findViewById<Button>(R.id.page4_button20)
        val button21 = findViewById<Button>(R.id.page4_button21)
        val button22 = findViewById<Button>(R.id.page4_button22)
        val button23 = findViewById<Button>(R.id.page4_button23)
        val button24 = findViewById<Button>(R.id.page4_button24)
        val button25 = findViewById<Button>(R.id.page4_button25)
        val button26 = findViewById<Button>(R.id.page4_button26)
        val button27 = findViewById<Button>(R.id.page4_button27)
        val button28 = findViewById<Button>(R.id.page4_button28)
        val button29 = findViewById<Button>(R.id.page4_button29)
        val button30 = findViewById<Button>(R.id.page4_button30)
        val button31 = findViewById<Button>(R.id.page4_button31)
        val button32 = findViewById<Button>(R.id.page4_button32)
        val button33 = findViewById<Button>(R.id.page4_button33)
        val button34 = findViewById<Button>(R.id.page4_button34)
        val button35 = findViewById<Button>(R.id.page4_button35)
        val button36 = findViewById<Button>(R.id.page4_button36)
        val button37 = findViewById<Button>(R.id.page4_button37)
        val button38 = findViewById<Button>(R.id.page4_button38)

        button18.isEnabled = true
        button19.isEnabled = true
        button20.isEnabled = true
        button21.isEnabled = true
        button22.isEnabled = true
        button23.isEnabled = true
        button24.isEnabled = true
        button25.isEnabled = true
        button26.isEnabled = true
        button27.isEnabled = true
        button28.isEnabled = true
        button29.isEnabled = true
        button30.isEnabled = true
        button31.isEnabled = true
        button32.isEnabled = true
        button33.isEnabled = true
        button34.isEnabled = true
        button35.isEnabled = true
        button36.isEnabled = true
        button37.isEnabled = true
        button38.isEnabled = true
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}