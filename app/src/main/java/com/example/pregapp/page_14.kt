package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.math.BigInteger
import java.security.MessageDigest

class page_14 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page14)

        auth = Firebase.auth
        val username = findViewById<TextView>(R.id.page14_text1)
        val email = findViewById<TextView>(R.id.page14_text2)

        val hash = md5(auth.currentUser?.email.toString())
        username.text = hash
        email.text = auth.currentUser?.email.toString()
        findData(hash)

        val icon1 = findViewById<ImageButton>(R.id.page14_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page14_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page14_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page14_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }

        val button1 = findViewById<Button>(R.id.page14_button1)
        button1.setOnClickListener{
            val page16 = Intent(applicationContext, page_16::class.java)
            startActivity(page16)
        }
        val button2 = findViewById<Button>(R.id.page14_button2)
        button2.setOnClickListener{
            Firebase.auth.signOut()
            val page1 = Intent(applicationContext, page_1::class.java)
            startActivity(page1)
            Toast.makeText(baseContext, "Wylogowono", Toast.LENGTH_SHORT).show()
        }
    }

    private fun findData(hash: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")
        val gender = findViewById<TextView>(R.id.page14_text4)
        val age = findViewById<TextView>(R.id.page14_text6)
        val weight = findViewById<TextView>(R.id.page14_text8)
        val height = findViewById<TextView>(R.id.page14_text10)
        val activity = findViewById<TextView>(R.id.page14_text12)

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == hash) {
                        gender.text = i.child("gender").value.toString()
                        age.text = i.child("age").value.toString()
                        weight.text = i.child("weight").value.toString()
                        height.text = i.child("height").value.toString()
                        activity.text = i.child("activity").value.toString()
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