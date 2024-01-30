package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
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

class page_19 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page19)

        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        createData(user)

        val icon1 = findViewById<ImageButton>(R.id.page19_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page19_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page19_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page19_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page19_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    private fun createData(user: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")
        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == user) {
                        if(!i.child("Measurement").child("Pressure").exists()) {
                            val database1 =
                                FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").reference.child(
                                    "UserID"
                                ).child(user).child("Measurement")
                            database1.child("Pressure").child("Status").setValue(0)
                            database1.child("Pressure").child("Number").setValue(0)
                            database1.child("Pressure").child("Values").setValue("0")
                        }
                    }
                    if(i.key.toString() == user) {
                        if(!i.child("Measurement").child("Oxygen").exists()) {
                            val database1 =
                                FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").reference.child(
                                    "UserID"
                                ).child(user).child("Measurement")
                            database1.child("Oxygen").child("Status").setValue(0)
                            database1.child("Oxygen").child("Number").setValue(0)
                            database1.child("Oxygen").child("Values").setValue("0")
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addValueEventListener(getdata)
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}