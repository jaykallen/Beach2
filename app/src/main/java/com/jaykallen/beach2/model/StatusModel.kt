package com.jaykallen.beach2.model





object StatusModel {
    // Setup
    val months = arrayOf("Dec","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
    val population = arrayOf(0, 1800, 1500, 1000, 3000, 800, 700, 800, 500, 400, 600, 1200, 1500)
    var month = 1               // Increments to 99. Mod 12 to get current month number.
    var year = 2019             // Initially set to next year
    var season = "High Season"
    var seasonColor = 0
    var header = "1: Jan 2019 (High Season)"
    var balance = 3000.0F       // Current balance
    var balanceOld = 3000.0F    // Last Month's balance

    // Expenses
    var drinks = 0              // 100 drinks produced per barrel
    var fruits = 0              // 1 lb per 25 crafts needed
    var ads = 10F               // Number of ads * 50 = expense
    var price = 2.5F            // Price of drink in dollars $5
    var rent = 600F             // Rent for 600 sq ft space
    var expenses = 1000F        // This month's expenses

    // Factors
    var weatherFactor = 0F
    var priceFactor = 0F
    var adFactor = 0F
    var numProd = 0

    // Results
    var temp = 0                // Avg weekly temp
    var weather = "Hot and Humid"
    var fruitResults = "Perfect amount of fruits"
    var popularity = 0          // Scale of 1-10. Dependent upon ads
    var sales = 0
    var gross = 0.5F
    var profit = 0.5F
}