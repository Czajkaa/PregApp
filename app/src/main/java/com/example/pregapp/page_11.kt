package com.example.pregapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.ImageButton
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private var arrayList: ArrayList<CalendarItem>? = null
private var calendarAdapter: CalendarAdapter? = null

class page_11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page11)

        val icon1 = findViewById<ImageButton>(R.id.page11_icon1)
        icon1.setOnClickListener{
            val page10 = Intent(applicationContext, page_10::class.java)
            startActivity(page10)
        }
        val icon3 = findViewById<ImageButton>(R.id.page11_icon3)
        icon3.setOnClickListener{
            val page12 = Intent(applicationContext, page_12::class.java)
            startActivity(page12)
        }
        val icon4 = findViewById<ImageButton>(R.id.page11_icon4)
        icon4.setOnClickListener{
            val page13 = Intent(applicationContext, page_13::class.java)
            startActivity(page13)
        }
        val icon5 = findViewById<ImageButton>(R.id.page11_icon5)
        icon5.setOnClickListener{
            val page14 = Intent(applicationContext, page_14::class.java)
            startActivity(page14)
        }

        val currentDate = Calendar.getInstance()
        var year = currentDate.get(Calendar.YEAR)
        var month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)
        val dayName = currentDate.get(Calendar.DAY_OF_WEEK) - 1
        val previous = findViewById<ImageButton>(R.id.date_previous)
        val next = findViewById<ImageButton>(R.id.date_next)
        val yearCheck = currentDate.get(Calendar.YEAR)
        val monthCheck = currentDate.get(Calendar.MONTH)

        val yearValue = findViewById<TextView>(R.id.date_display_year)
        val monthValue = findViewById<TextView>(R.id.date_display_month)
        val dayValue = findViewById<TextView>(R.id.date_display_day)
        val dayNameValue = findViewById<Button>(R.id.date_display_dayname)

        yearValue.text = year.toString()
        monthValue.text = nameOfMonth()[month]
        dayValue.text = day.toString()
        dayNameValue.text = dayOfWeek()[dayName]
        val gridView = findViewById<GridView>(R.id.calendar_grid)

        val fromDateCheck = if(monthCheck+1 < 10) "01/0${monthCheck+1}/$yearCheck"
        else "01/${monthCheck+1}/$yearCheck"
        var fromDate = if(month+1 < 10) "01/0${month+1}/$year"
        else "01/${month+1}/$year"
        arrayList = setDataList(fromDate, currentDate, month, year)
        calendarAdapter = CalendarAdapter(applicationContext, arrayList!!)
        gridView.adapter = calendarAdapter

        previous.setOnClickListener{
            if (month == 0) {
                month = 12
                year -= 1
            }
            month -= 1
            monthValue.text = nameOfMonth()[month]
            yearValue.text = year.toString()
            fromDate = if(month+1 < 10) "01/0${month+1}/$year"
            else "01/${month+1}/$year"

            arrayList = setDataList(fromDate, currentDate, month, year)
            calendarAdapter = CalendarAdapter(applicationContext, arrayList!!)
            gridView.adapter = calendarAdapter

            BackButton(fromDate, fromDateCheck, dayName)
        }
        next.setOnClickListener{
            if (month == 11) {
                month = -1
                year += 1
            }
            month += 1
            monthValue.text = nameOfMonth()[month]
            yearValue.text = year.toString()
            fromDate = if(month+1 < 10) "01/0${month+1}/$year"
            else "01/${month+1}/$year"
            arrayList = setDataList(fromDate, currentDate, month, year)
            calendarAdapter = CalendarAdapter(applicationContext, arrayList!!)
            gridView.adapter = calendarAdapter

            BackButton(fromDate, fromDateCheck, dayName)
        }
        dayNameValue.setOnClickListener {
            year = yearCheck
            month = monthCheck
            monthValue.text = nameOfMonth()[month]
            yearValue.text = year.toString()
            fromDate = if(month+1 < 10) "01/0${month+1}/$year"
            else "01/${month+1}/$year"
            arrayList = setDataList(fromDate, currentDate, month, year)
            calendarAdapter = CalendarAdapter(applicationContext, arrayList!!)
            gridView.adapter = calendarAdapter

            BackButton(fromDate, fromDateCheck, dayName)
        }
    }

    private fun BackButton(fromDate: String, fromDateCheck: String, dayName: Int) {
        val dayNameValue = findViewById<Button>(R.id.date_display_dayname)
        dayNameValue.isEnabled = true
        if (fromDate != fromDateCheck) {
            dayNameValue.text = "Powrót"
            dayNameValue.setBackgroundResource(R.drawable.button_effect2)
            dayNameValue.setTextColor(resources.getColor(R.color.white))
        } else {
            dayNameValue.isEnabled = false
            dayNameValue.text = dayOfWeek()[dayName]
            dayNameValue.setBackgroundResource(R.drawable.button_effect3)
            dayNameValue.setTextColor(resources.getColor(R.color.black))
        }
    }

    private fun setDataList(fromDate: String, currentDate: Calendar, month: Int, year: Int): ArrayList<CalendarItem> {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val date = sdf.parse(fromDate)
        sdf.applyPattern("EEE")
        val str = date?.let { sdf.format(it) }
        val arrayList: ArrayList<CalendarItem> = ArrayList()

        if(str == "Mon") {
            for (i in 1..daysInMonth(currentDate, month, year)) {
                arrayList.add(CalendarItem(i))
            }
        }
        else if(str == "Tue") {
            for (i in 1..1) {
                arrayList.add(CalendarItem(0))
            }
            for (i in 1..daysInMonth(currentDate, month, year)) {
                arrayList.add(CalendarItem(i))
            }
        }
        else if(str == "Wed") {
            for (i in 1..2) {
                arrayList.add(CalendarItem(0))
            }
            for (i in 1..daysInMonth(currentDate, month, year)) {
                arrayList.add(CalendarItem(i))
            }
        }
        else if(str == "Thu") {
            for (i in 1..3) {
                arrayList.add(CalendarItem(0))
            }
            for (i in 1..daysInMonth(currentDate, month, year)) {
                arrayList.add(CalendarItem(i))
            }
        }
        else if(str == "Fri") {
            for (i in 1..4) {
                arrayList.add(CalendarItem(0))
            }
            for (i in 1..daysInMonth(currentDate, month, year)) {
                arrayList.add(CalendarItem(i))
            }
        }
        else if(str == "Sat") {
            for (i in 1..5) {
                arrayList.add(CalendarItem(0))
            }
            for (i in 1..daysInMonth(currentDate, month, year)) {
                arrayList.add(CalendarItem(i))
            }
        }
        else {
            for (i in 1..6) {
                arrayList.add(CalendarItem(0))
            }
            for (i in 1..daysInMonth(currentDate, month, year)) {
                arrayList.add(CalendarItem(i))
            }
        }

        return arrayList
    }

    private fun daysInMonth(currentDate: Calendar, month: Int, year: Int): Int {
        currentDate.set(Calendar.MONTH, month)
        currentDate.set(Calendar.YEAR, year)
        return currentDate.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    private fun dayOfWeek(): ArrayList<String> {
        val dayName: ArrayList<String> = ArrayList()
        dayName.add("Niedziela")
        dayName.add("Poniedziałek")
        dayName.add("Wtorek")
        dayName.add("Środa")
        dayName.add("Czwartek")
        dayName.add("Piątek")
        dayName.add("Sobota")
        return dayName
    }

    private fun nameOfMonth(): ArrayList<String> {
        val monthName: ArrayList<String> = ArrayList()
        monthName.add("Sty")
        monthName.add("Lut")
        monthName.add("Mar")
        monthName.add("Kwi")
        monthName.add("Maj")
        monthName.add("Cze")
        monthName.add("Lip")
        monthName.add("Sie")
        monthName.add("Wrz")
        monthName.add("Paź")
        monthName.add("Lis")
        monthName.add("Gru")
        return monthName
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}