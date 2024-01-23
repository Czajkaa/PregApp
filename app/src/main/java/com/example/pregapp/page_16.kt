package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
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

class page_16 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page16)

        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        findData(user)

        val genderInput = findViewById<Spinner>(R.id.page16_dropdown1)
        val ageInput = findViewById<EditText>(R.id.page16_editText3)
        val weightInput = findViewById<EditText>(R.id.page16_editText4)
        val heightInput = findViewById<EditText>(R.id.page16_editText5)
        val activityInput = findViewById<Spinner>(R.id.page16_dropdown2)
        val pragnetInput = findViewById<Spinner>(R.id.page16_dropdown3)
        val howCycleInput = findViewById<Spinner>(R.id.page16_dropdown4)
        val howPeriodInput = findViewById<Spinner>(R.id.page16_dropdown5)
        val codeInput = findViewById<EditText>(R.id.page16_editText6)

        val button1 = findViewById<Button>(R.id.page16_button1)
        button1.setOnClickListener{
            val gender = genderInput.selectedItem.toString()
            val age = ageInput.text.toString().trim() {it <= ' '}
            val weight = weightInput.text.toString().trim() {it <= ' '}
            val height = heightInput.text.toString().trim() {it <= ' '}
            val activity = activityInput.selectedItem.toString()
            var pragnet = "0"
            if(pragnetInput.selectedItem.toString() == "Tak") {
                val currentDate = Calendar.getInstance()
                val year = currentDate.get(Calendar.YEAR)
                val month = currentDate.get(Calendar.MONTH) + 1
                val day = currentDate.get(Calendar.DAY_OF_MONTH)
                val date = if(day < 10 && month < 10) "0$day/0$month/$year"
                else if (day >= 10 && month < 10) "$day/0$month/$year"
                else if (day < 10 && month >= 10) "0$day/$month/$year"
                else "$day/$month/$year"

                pragnet = "1"
                updatePragnetDate(date)
            } else {
                val date = "00/00/0000"
                updatePragnetDate(date)
            }
            val howCycle = howCycleInput.selectedItem.toString()
            val howPeriod = howPeriodInput.selectedItem.toString()
            val code = codeInput.text.toString().trim() {it <= ' '}

            updateGender(gender)
            updateAge(age)
            updateWeight(weight)
            updateHeight(height)
            updateActivity(activity)
            updateHowCycle(howCycle)
            updateHowPeriod(howPeriod)
            updatePragnet(pragnet)
            updateCode(code)

            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    private fun findData(hash: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")
        val gender = findViewById<Spinner>(R.id.page16_dropdown1)
        val age = findViewById<EditText>(R.id.page16_editText3)
        val weight = findViewById<EditText>(R.id.page16_editText4)
        val height = findViewById<EditText>(R.id.page16_editText5)
        val activity = findViewById<Spinner>(R.id.page16_dropdown2)
        val pragnetTitle = findViewById<TextView>(R.id.page16_text7)
        val pragnet = findViewById<Spinner>(R.id.page16_dropdown3)
        val howCycleTitle = findViewById<TextView>(R.id.page16_text8)
        val howCycle = findViewById<Spinner>(R.id.page16_dropdown4)
        val howPeriodTitle = findViewById<TextView>(R.id.page16_text9)
        val howPeriod = findViewById<Spinner>(R.id.page16_dropdown5)
        val codeTitle = findViewById<TextView>(R.id.page16_text10)
        val code = findViewById<EditText>(R.id.page16_editText6)

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == hash) {
                        if(i.child("UserData").key.toString() == "UserData") {
                            var pragnetValue = "Nie"
                            if(i.child("UserData").child("pragnet").value.toString() == "1") pragnetValue = "Tak"
                            if(i.child("UserData").child("gender").value.toString() == "Mężczyzna") {
                                pragnetTitle.visibility = View.GONE
                                pragnet.visibility = View.GONE
                                howCycleTitle.visibility = View.GONE
                                howCycle.visibility = View.GONE
                                howPeriodTitle.visibility = View.GONE
                                howPeriod.visibility = View.GONE
                                codeTitle.visibility = View.VISIBLE
                                code.visibility = View.VISIBLE
                            }

                            gender.setSelection(getIndex(gender, i.child("UserData").child("gender").value.toString()))
                            age.setText(i.child("UserData").child("age").value.toString())
                            weight.setText(i.child("UserData").child("weight").value.toString())
                            height.setText(i.child("UserData").child("height").value.toString())
                            activity.setSelection(getIndex(activity, i.child("UserData").child("activity").value.toString()))
                            pragnet.setSelection(getIndex(pragnet, pragnetValue))
                            howCycle.setSelection(getIndex(howCycle, i.child("UserData").child("howCycle").value.toString()))
                            howPeriod.setSelection(getIndex(howPeriod, i.child("UserData").child("howPeriod").value.toString()))
                            code.setText(i.child("UserData").child("code").value.toString())
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addListenerForSingleValueEvent(getdata)
    }

    private fun getIndex(spinner: Spinner, myString: String): Int {
        for (i in 0 until spinner.count)  {
            if (spinner.getItemAtPosition(i).toString().equals(myString, ignoreCase = true)) {
                return i
            }
        }
        return 0
    }

    private fun updateGender(gender: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("gender")
        database.setValue(gender)
    }

    private fun updateAge(age: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("age")
        database.setValue(age)
    }

    private fun updateWeight(weight: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("weight")
        database.setValue(weight)
    }

    private fun updateHeight(height: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("height")
        database.setValue(height)
    }

    private fun updateActivity(activity: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("activity")
        database.setValue(activity)
    }

    private fun updateHowCycle(howCycle: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("howCycle")
        database.setValue(howCycle)
    }

    private fun updateHowPeriod(howPeriod: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("howPeriod")
        database.setValue(howPeriod)
    }

    private fun updatePragnet(pragnet: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("pragnet")
        database.setValue(pragnet)
    }

    private fun updateCode(code: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("code")
        database.setValue(code)
    }

    private fun updatePragnetDate(date: String) {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("UserData").child("pragnetDate")
        database.setValue(date)
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}