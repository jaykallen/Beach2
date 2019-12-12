package com.jaykallen.beach2.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jaykallen.beach2.R
import com.jaykallen.beach2.model.StatusModel
import kotlinx.android.synthetic.main.fragment_profit.*


class ProfitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profit, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Profit Fragment *******************")
        updateUI()
    }

    private fun updateUI() {
        val craftCost = StatusModel.drinks * 1F
        craftText.text = "$ ${String.format("%.2f", craftCost)}"
        val fruitCost = StatusModel.fruits * 3F
        fruitText.text = "$ ${String.format("%.2f", fruitCost)}"
        val adCost = StatusModel.ads * 50F
        adText.text = "$ ${String.format("%.2f", adCost)}"
        val rentCost = StatusModel.rent * 1F
        rentText.text = "$ ${String.format("%.2f", rentCost)}"
        val expenseTotal = StatusModel.expenses * 1F
        expensesText.text = "$ ${String.format("%.2f", expenseTotal)}"
    }

}
