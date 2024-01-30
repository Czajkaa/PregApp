package com.example.pregapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.PointsGraphSeries
import java.math.BigInteger
import java.security.MessageDigest

class page_20 : AppCompatActivity() {
    private lateinit var plot1: GraphView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page20)

        auth = Firebase.auth
        val user = md5(auth.currentUser?.email.toString())

        val button1 = findViewById<Button>(R.id.page20_button1)
        val button2 = findViewById<Button>(R.id.page20_button2)
        val button3 = findViewById<Button>(R.id.page20_button3)

        button1.setOnClickListener{
            getPonits(user, "Temperature")
            button1.isEnabled = false
            button2.isEnabled = true
            button3.isEnabled = true
        }
        button2.setOnClickListener{
            getPonits(user, "Pressure")
            button1.isEnabled = true
            button2.isEnabled = false
            button3.isEnabled = true
        }
        button3.setOnClickListener{
            getPonits(user, "Oxygen")
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = false
        }



        val icon1 = findViewById<ImageButton>(R.id.page20_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon2 = findViewById<ImageButton>(R.id.page20_icon2)
        icon2.setOnClickListener{
            val page11 = Intent(applicationContext, page_11::class.java)
            startActivity(page11)
        }
        val icon3 = findViewById<ImageButton>(R.id.page20_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page20_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page20_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }
    }

    private fun getPonits(user: String, mode: String) {
        var plotPonits = arrayOf<DataPoint>()
        var xaxis = 1.0
        val database =
            FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").reference.child(
                "UserID").child(user).child("Measurement").child(mode).child("Values")
        val getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    val x = i.key.toString().toDouble()
                    val y = i.value.toString().toDouble()
                    plotPonits += DataPoint(x,y)
                    xaxis += 1
                }
                plot1 = findViewById(R.id.page20_plot1)
                val series: PointsGraphSeries<DataPoint> = PointsGraphSeries<DataPoint>(plotPonits)
                plot1.addSeries(series)

                plot1.viewport.setMinX(0.0)
                plot1.viewport.setMaxX(xaxis)
                if(mode == "Temperature") {
                    plot1.viewport.setMinY(30.0)
                    plot1.viewport.setMaxY(40.0)
                }
                if(mode == "Pressure") {
                    plot1.viewport.setMinY(70.0)
                    plot1.viewport.setMaxY(100.0)
                }
                if(mode == "Oxygen") {
                    plot1.viewport.setMinY(70.0)
                    plot1.viewport.setMaxY(100.0)
                }

                plot1.viewport.isYAxisBoundsManual = true
                plot1.viewport.isXAxisBoundsManual = true
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addValueEventListener(getdata)
    }

    private fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}