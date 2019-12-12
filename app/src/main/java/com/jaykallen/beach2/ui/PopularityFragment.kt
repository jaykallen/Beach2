package com.jaykallen.beach2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jaykallen.beach2.R
import com.jaykallen.beach2.helper.Helper
import com.jaykallen.beach2.model.StatusModel
import kotlinx.android.synthetic.main.fragment_popularity.*

class PopularityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popularity, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Popularity Fragment *******************")
        updateUI()
    }

    private fun updateUI() {
        val signs = StatusModel.ads * 1F
        signsText.text = "$signs"
        val expense = StatusModel.ads * 50F
        expenseText.text = "$ ${String.format("%.2f", expense)}"
        val popularity = StatusModel.popularity
        popularityText.text = "${popularity}/10"
        val passers = Helper.getPopulation(StatusModel.month)
        passersText.text = "$passers"
    }
}
