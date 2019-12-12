package com.jaykallen.beach2.helper

import java.util.*

class Utils {
    companion object {
        val months = arrayOf("Dec","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")

        fun getMonthName(month: Int): String {
            return months[month%12]
        }

        fun getNextYear(date: Date): Int {
            val cal = Calendar.getInstance()
            cal.time = date
            cal.add(Calendar.YEAR, 1)
            return cal.get(Calendar.YEAR)
        }

        fun getMonth(date: Date): Int {
            val cal = Calendar.getInstance()
            cal.time = date
            return cal.get(Calendar.MONTH)
        }

        fun getYear(date: Date): Int {
            val cal = Calendar.getInstance()
            cal.time = date
            return cal.get(Calendar.YEAR)
        }
    }
}