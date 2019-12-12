package com.jaykallen.beach2.helper

import com.jaykallen.beach2.model.StatusModel
import com.jaykallen.beach2.model.WeatherModel
import timber.log.Timber
import java.util.*

/**
 * Created by Jay Kallen on 6/22/18.
 * Jan - Mar: High, Apr: Junkanoo, May - Jun: Normal, Jul - Oct: Hurricane, Nov - Dec: High
 */

class Helper {
    companion object {
        private var overallFactor = 0F

        fun getPopulation(month: Int):Int {
            val population = arrayOf(0, 1800, 1500, 1000, 3000, 800, 700, 800, 500, 400, 600, 1200, 1500)
            return population[month % 12]
        }

        fun setResults() {
            setWeather()
            setAdFactor()
            setPriceFactor()
            setNumProd()
            setPopularity()
            setExpenses()
            setSales()
            setFruits()
        }

        private fun setWeather() {
            val tempArray = arrayOf(0, 76, 79, 80, 80, 81, 84, 86, 91, 87, 85, 82, 77)
            var rand = Random().nextInt(6 - 1) + 1
            WeatherModel.weather = when (rand) {
                1 -> "Rainy"
                2 -> "Cloudy"
                3 -> "Sun & Cloud Mix"
                4 -> "Sunny"
                5 -> "Hot & Humid"
                else -> "Hurricane!"
            }
            WeatherModel.temp = when (rand) {
                1 -> tempArray[StatusModel.month] - 10
                2 -> tempArray[StatusModel.month] - 5
                3 -> tempArray[StatusModel.month]
                4 -> tempArray[StatusModel.month] + 5
                5 -> tempArray[StatusModel.month] + 10
                else -> 70
            }
            if ((StatusModel.month == 8 || StatusModel.month == 9 || StatusModel.month == 10) && rand <3) {
                WeatherModel.weather = "Hurricane!"
                WeatherModel.temp = 50
                WeatherModel.weatherFactor = 0.1F
            } else {
                WeatherModel.weatherFactor = WeatherModel.temp / 100F
            }
            Timber.d ("${WeatherModel.weather}, avg temp=${WeatherModel.temp}, Factor=${WeatherModel.weatherFactor}")
        }

        fun setFruits() {
            val slices = StatusModel.fruits * 25
            val fruitString = when {
                (StatusModel.drinks > (slices * 1.9)) -> "Not nearly enough fruits"
                (StatusModel.drinks > (slices * 1.19)) -> "Not enough fruits"
                (StatusModel.drinks > (slices * 1.1)) -> "Almost enough fruits"
                (StatusModel.drinks == slices) -> "Perfect amount of fruits"
                (StatusModel.drinks < (slices / 1.9)) -> "Waaay too many fruits"
                (StatusModel.drinks < (slices / 1.19)) -> "Too many fruits"
                (StatusModel.drinks < (slices / 1.1)) -> "A few too many fruits"
                else -> "Almost perfect amount of fruits"
            }
            StatusModel.fruitResults = fruitString
        }

        private fun setSales() {
            val sales = getPopulation(
                StatusModel.month
            ) * overallFactor
            if (sales > StatusModel.numProd) {
                StatusModel.sales = StatusModel.numProd
            } else {
                StatusModel.sales = sales.toInt()
            }
            StatusModel.gross = StatusModel.sales * StatusModel.price
            StatusModel.profit = StatusModel.gross - StatusModel.expenses
            StatusModel.balance = StatusModel.balance - StatusModel.expenses + StatusModel.profit
            Timber.d("sales=${StatusModel.sales} price=${StatusModel.price} gross=${StatusModel.gross} profit=${StatusModel.profit}")
            Timber.d("expenses=${StatusModel.expenses} new balance=${StatusModel.balance}")
        }

        private fun setExpenses() {
            StatusModel.expenses = StatusModel.drinks + (StatusModel.fruits * 3) + (StatusModel.ads * 50) + StatusModel.rent
        }

        private fun setPopularity() {
            overallFactor = WeatherModel.weatherFactor * StatusModel.priceFactor * StatusModel.adFactor
            val pop = overallFactor * 10F
            Timber.d("Popularity=$pop")
            StatusModel.popularity = if (pop > 10) 10 else pop.toInt()
        }

        private fun setNumProd() {
            val slices = (StatusModel.fruits * 25)
            val drinks = StatusModel.drinks
            if (slices >= drinks) {
                StatusModel.numProd = drinks
            } else {
                StatusModel.numProd = slices
            }
            Timber.d("Crafts=${StatusModel.drinks}, Slices=${StatusModel.fruits}, Prod=${StatusModel.numProd}")
        }

        private fun setPriceFactor() {
            val cost = arrayOf(0, 8, 8, 7, 10, 5, 5, 4, 4, 3, 4, 7, 7)
            val expectedPrice = cost[StatusModel.month]
            if (StatusModel.price > 0F) {
                StatusModel.priceFactor = expectedPrice / StatusModel.price
            } else {
                StatusModel.priceFactor = 1F
            }
            Timber.d("Price Factor=${StatusModel.priceFactor}")
        }

        private fun setAdFactor() {
            val ads = StatusModel.ads
            val adFactor = when {
                ads >= 10F -> .5F
                ads > 0F && ads < 10F -> ads/20F
                else -> 0F
            }
            StatusModel.adFactor = .5F + adFactor
            Timber.d ("Ad Factor=${StatusModel.adFactor}")
        }

    }
}