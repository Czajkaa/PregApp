package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
import java.util.Calendar

class page_13 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page13)

        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        findPragnet(user)
        findGender(user)
        
        val icon1 = findViewById<ImageButton>(R.id.page13_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page13_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page13_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon5 = findViewById<ImageButton>(R.id.page13_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }

        val button1 = findViewById<Button>(R.id.page13_button1)

        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH) + 1
        val day = currentDate.get(Calendar.DAY_OF_MONTH)
        val date = if(day < 10 && month < 10) "0$day/0$month/$year"
        else if (day >= 10 && month < 10) "$day/0$month/$year"
        else if (day < 10 && month >= 10) "0$day/$month/$year"
        else "$day/$month/$year"

        button1.setOnClickListener{
            updatePragnetDate(date)
            updatePragnet("1")
            Toast.makeText(baseContext, R.string.page13_text3, Toast.LENGTH_SHORT).show()
            findPragnet(user)
        }
    }

    private fun findPragnet(hash: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == hash) {
                        if(i.child("UserData").key.toString() == "UserData") {
                            if(i.child("UserData").child("pragnet").value.toString() == "1") {
                                val page21 = Intent(applicationContext, page_21::class.java)
                                startActivity(page21)
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

    private fun findGender(hash: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == hash) {
                        if(i.child("UserData").key.toString() == "UserData") {
                            val button1 = findViewById<Button>(R.id.page13_button1)
                            val text1 = findViewById<TextView>(R.id.page13_text1)

                            if(i.child("UserData").child("gender").value.toString() == "Mężczyzna") {
                                button1.visibility = View.GONE
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

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    private fun updatePragnet(pragnet: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("pragnet")
        database.setValue(pragnet)
    }

    private fun updatePragnetDate(date: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("pragnetDate")
        database.setValue(date)
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}