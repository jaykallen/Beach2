package com.jaykallen.beach2.helper

import android.content.Context
import androidx.core.content.ContextCompat
import com.jaykallen.beach2.R
import com.jaykallen.beach2.model.StatusModel
import timber.log.Timber
import java.util.*

class SetupHelper {
    companion object {
        fun initModel() {
            StatusModel.month = 1
            StatusModel.year = Utils.getNextYear(Date())
            StatusModel.balance = 3000.0F
            Timber.d("Initial month set to " + StatusModel.month + " " + StatusModel.year)
        }

        fun nextMonth() {
            if (StatusModel.month % 12 == 0) {
                StatusModel.year++
            }
            StatusModel.month++
        }

        fun setSeason(context: Context) {
            when {
                StatusModel.month == 4 -> {
                    StatusModel.season = "Junkanoo Carnival"
                    StatusModel.seasonColor = ContextCompat.getColor(context, R.color.colorJunkanoo)
                }
                StatusModel.month in 5..7 -> {
                    StatusModel.season = "Normal Season"
                    StatusModel.seasonColor = ContextCompat.getColor(context, R.color.colorNormal)
                }
                StatusModel.month in 8..10 -> {
                    StatusModel.season = "Hurricane Season"
                    StatusModel.seasonColor = ContextCompat.getColor(context, R.color.colorLow)
                }
                else -> {
                    StatusModel.season = "High Season"
                    StatusModel.seasonColor = ContextCompat.getColor(context, R.color.colorHigh)
                }
            }
        }

        fun setHeader() {
            StatusModel.header = "${StatusModel.month}: ${Utils.getMonthName(StatusModel.month)} ${StatusModel.year} (${StatusModel.season})"
        }
    }
}