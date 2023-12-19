package com.example.pregapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CalendarAdapter(var context: Context, private var arrayList:ArrayList<CalendarItem>): BaseAdapter() {
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
        } else {
            view = View.inflate(context, R.layout.calendar_row1, null)
            numbers = view.findViewById(R.id.date_text)
        }

        numbers.text = calendarItem.number.toString()
        return view
    }
}