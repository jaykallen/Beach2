package com.jaykallen.beach2.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jaykallen.beach2.R
import com.jaykallen.beach2.model.WeatherModel
import kotlinx.android.synthetic.main.fragment_weather.*


class WeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Weather Fragment *******************")
        updateUI()
    }

    private fun updateUI() {
        weatherText.text = WeatherModel.weather
        tempText.text = "" + WeatherModel.temp
        val lost = (1F - WeatherModel.weatherFactor) * 100F
        lostText.text = "$lost %"
    }

}
