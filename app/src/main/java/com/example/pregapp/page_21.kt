package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
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
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Calendar

class page_21 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page21)

        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())
        findPragnetDate(user)

        val button1 = findViewById<Button>(R.id.page21_button1)
        button1.setOnClickListener{
            val page22 = Intent(applicationContext, page_22::class.java)
            startActivity(page22)
        }

        val icon1 = findViewById<ImageButton>(R.id.page21_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page21_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page21_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page21_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page21_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    private fun findPragnetDate(hash: String) {
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID")

        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if(i.key.toString() == hash) {
                        if(i.child("UserData").key.toString() == "UserData") {
                            var trimester_no = "-"
                            val trimester = findViewById<TextView>(R.id.page21_text3)

                            val pragnetDate = i.child("UserData").child("pragnetDate").value.toString()
                            val currentDate = Calendar.getInstance()
                            val year = currentDate.get(Calendar.YEAR)
                            val month = currentDate.get(Calendar.MONTH) + 1
                            val day = currentDate.get(Calendar.DAY_OF_MONTH)
                            val date = if(day < 10 && month < 10) "0$day/0$month/$year"
                            else if (day >= 10 && month < 10) "$day/0$month/$year"
                            else if (day < 10 && month >= 10) "0$day/$month/$year"
                            else "$day/$month/$year"

                            val dateFormatter: DateTimeFormatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy")
                            val from = LocalDate.parse(pragnetDate, dateFormatter)
                            val to = LocalDate.parse(date, dateFormatter)

                            when(Period.between(from, to).months*4) {
                                in 0..13 -> trimester_no = "1"
                                in 14..27 -> trimester_no = "2"
                                in 28..40 -> trimester_no = "3"
                                else -> trimester_no = "-"
                            }
                            trimester.text = trimester_no.toString()

                            val weight = i.child("UserData").child("weight").value.toString().toInt()
                            val height = i.child("UserData").child("height").value.toString().toInt()

                            kcal_per_trymestr(weight, height, trimester_no.toInt())
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

    fun kcal_per_trymestr(weight: Int, height: Int, trimester: Int){
        var total_E = 0.0
        val base_E = 655.1 + (9.567 * weight) + (1.85 * height)
        if (trimester == 1){
            total_E = base_E
        }else if(trimester == 2){
            total_E = base_E + 360
        } else {
            total_E = base_E + 475
        }

        val kcal_text = findViewById<TextView>(R.id.page21_text5)
        kcal_text.text = total_E.toInt().toString()
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}