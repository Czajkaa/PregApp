package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import java.math.BigInteger
import java.security.MessageDigest

class page_15 : AppCompatActivity() {
    private var check1: Boolean = false
    private var check2: Boolean = false
    private var check3: Boolean = false
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page15)

        val inputGender = findViewById<Spinner>(R.id.page15_dropdown1)
        val inputAge = findViewById<EditText>(R.id.page15_editText3)
        val inputWeight = findViewById<EditText>(R.id.page15_editText4)
        val inputHeight = findViewById<EditText>(R.id.page15_editText5)
        val inputActivity = findViewById<Spinner>(R.id.page15_dropdown2)
        auth = Firebase.auth
        inputChanged(inputAge, inputWeight, inputHeight)

        val button1 = findViewById<Button>(R.id.page15_button1)
        button1.isEnabled = false
        button1.setOnClickListener{
            val gender = inputGender.selectedItem.toString()
            val age = inputAge.text.toString().trim() {it <= ' '}
            val weight = inputWeight.text.toString().trim() {it <= ' '}
            val height = inputHeight.text.toString().trim() {it <= ' '}
            val activity = inputActivity.selectedItem.toString()

            val user = md5(auth.currentUser?.email.toString())
            val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
            reference.child("UserID").child(user).child("UserData")
            val data = createData(gender, age, weight, height, activity, "0", "0", "brak", "0")
            database.setValue(data)

            val database2 = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
            reference.child("UserID").child(user).child("UserData").child("code")
            database2.setValue("")

            if(gender == "Kobieta") {
                val page3 = Intent(applicationContext, page_3::class.java)
                startActivity(page3)
            } else {
                Toast.makeText(this, resources.getString(R.string.toast1), Toast.LENGTH_LONG).show()
                val page1 = Intent(applicationContext, page_1::class.java)
                startActivity(page1)
            }


        }
    }

    private fun inputChanged(inputAge:EditText, inputWeight:EditText, inputHeight:EditText) {
        inputAge.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val age1: Int
                val age: String = inputAge.text.toString().trim() {it <= ' '}

                age1 = if (age == "") 0
                else age.toInt()
                check1 = age1 >= 18 == true
                sumCheck()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        inputWeight.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val weight1: Int
                val weight: String = inputWeight.text.toString().trim() {it <= ' '}

                weight1 = if (weight == "") 0
                else weight.toInt()
                check2 = weight1 >= 40 == true
                sumCheck()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        inputHeight.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val height1: Int
                val height: String = inputHeight.text.toString().trim() {it <= ' '}

                height1 = if (height == "") 0
                else height.toInt()
                check3 = height1 >= 120 == true
                sumCheck()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun sumCheck() {
        val button1 = findViewById<Button>(R.id.page15_button1)
        button1.isEnabled = check1 && check2 && check3 == true
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}