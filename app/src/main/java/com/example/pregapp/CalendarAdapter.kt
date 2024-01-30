package com.example.pregapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

class CalendarAdapter(var context: Context, private var arrayList:ArrayList<CalendarItem>): BaseAdapter() {
    private lateinit var auth: FirebaseAuth
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val calendarItem: CalendarItem = arrayList[position]
        val view: View
        val numbers: TextView

        if(calendarItem.number.toString() == "0") {
            view = View.inflate(context, R.layout.calendar_row2, null)
            numbers = view.findViewById(R.id.date_text)
        } else if(calendarItem.number.toString() == "5") {
            view = View.inflate(context, R.layout.calendar_row3, null)
            numbers = view.findViewById(R.id.date_text)
        }
        else {
            view = View.inflate(context, R.layout.calendar_row1, null)
            numbers = view.findViewById(R.id.date_text)
        }

        numbers.text = calendarItem.number.toString()
        return view
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}