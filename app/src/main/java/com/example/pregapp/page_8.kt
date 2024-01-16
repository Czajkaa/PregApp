package com.example.pregapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import java.math.BigInteger
import java.security.MessageDigest

class page_8 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page8)

        val inputDevice = findViewById<EditText>(R.id.page8_editText1)
        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("device")

        inputChanged(inputDevice)

        val button1 = findViewById<Button>(R.id.page8_button1)
        button1.isEnabled = false
        button1.setOnClickListener{
            val device: String = inputDevice.text.toString().trim() {it <= ' '}
            database.setValue(device)
            Toast.makeText(this, resources.getString(R.string.toast1), Toast.LENGTH_LONG).show()
            val page1 = Intent(applicationContext, page_1::class.java)
            startActivity(page1)
        }
    }

    private fun inputChanged(inputDevice: EditText) {
        inputDevice.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                deviceValidation(inputDevice)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun deviceValidation(inputDevice: EditText) {
        val button1 = findViewById<Button>(R.id.page8_button1)
        val device: String = inputDevice.text.toString().trim() {it <= ' '}
        button1.isEnabled = device != ""
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}