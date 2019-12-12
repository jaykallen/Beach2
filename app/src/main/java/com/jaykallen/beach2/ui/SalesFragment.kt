package com.jaykallen.beach2.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jaykallen.beach2.R
import com.jaykallen.beach2.helper.Helper
import com.jaykallen.beach2.model.StatusModel
import kotlinx.android.synthetic.main.fragment_sales.*


class SalesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sales, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Sales Fragment *******************")
        updateUI()
    }

    private fun updateUI() {
        val passers = Helper.getPopulation(StatusModel.month)
        passersText.text = "$passers"
        val sales = StatusModel.sales
        salesText.text = "$sales"
        val price = StatusModel.price
        priceText.text = "$ ${String.format("%.2f", price)}"
        val gross = StatusModel.gross * 1F
        grossText.text = "$ ${String.format("%.2f", gross)}"
        val salesGained = StatusModel.sales - Helper.getPopulation(StatusModel.month)
        salesGainedText.text = "$salesGained"
    }

}
