package com.jaykallen.beach2.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jaykallen.beach2.R
import com.jaykallen.beach2.model.StatusModel
import kotlinx.android.synthetic.main.fragment_make.*


class MakeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_make, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Make Fragment *******************")
        updateUI()
    }

    private fun updateUI() {
        val brewed = StatusModel.drinks
        brewedText.text = "$brewed"
        val slices = (StatusModel.fruits * 25)
        val drinks = StatusModel.drinks
        val servable = if (slices >= drinks) { drinks } else { slices }
        servableText.text = "$servable"
        val fruits = StatusModel.fruits
        fruitText.text = "$fruits"
        val ratio = (StatusModel.fruits.toFloat() / StatusModel.drinks.toFloat()) * 100F
        ratioText.text = "${ratio} : 1"
        commentsText.text = "\"${StatusModel.fruitResults}\""
    }

}
