package com.jaykallen.beach2.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jaykallen.beach2.R
import com.jaykallen.beach2.StartApp
import com.jaykallen.beach2.helper.SetupHelper
import com.jaykallen.beach2.model.StatusModel
import com.jaykallen.beach2.model.WeatherModel
import kotlinx.android.synthetic.main.fragment_summary.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay


class SummaryFragment : Fragment() {
    private var thread: Deferred<Unit>? = null
    val duration = 2000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Results Fragment *******************")
        updateUI()
        setWeatherDisplay()
    }

    private fun updateUI() {
        val title = "Summary for Month #${StatusModel.header}"
        summaryText.text = title
        summaryText.setBackgroundColor(StatusModel.seasonColor)
        val profit = StatusModel.profit * 1F
        profitText.text = "$ ${String.format("%.2f", profit)}"
        val balanceOld = StatusModel.balance - StatusModel.expenses * 1F
        oldBalanceText.text = "$ ${String.format("%.2f", balanceOld)}"
        val balance = StatusModel.balance * 1F
        balanceText.text = "$ ${String.format("%.2f", balance)}"
    }

    private fun setWeatherDisplay() {
        thread = GlobalScope.async {
            delay(duration.toLong())
            when (WeatherModel.weather) {
                "Rainy" -> weatherLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        StartApp.instance,
                        R.color.colorRainy
                    )
                )
                "Cloudy" -> weatherLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        StartApp.instance,
                        R.color.colorCloudy
                    )
                )
                "Sun & Cloud Mix" -> weatherLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        StartApp.instance,
                        R.color.colorMixed
                    )
                )
                "Sunny" -> weatherLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        StartApp.instance,
                        R.color.colorSunny
                    )
                )
                "Hot & Humid" -> weatherLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        StartApp.instance,
                        R.color.colorHot
                    )
                )
                else -> weatherLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        StartApp.instance,
                        R.color.colorHurricane
                    )
                )
            }
            weatherProgress.visibility = View.INVISIBLE
            weatherText.visibility = View.VISIBLE
            weatherText.text = WeatherModel.weather
            showAdResults()
        }
    }

    private fun showAdResults() {
        thread = GlobalScope.async {
            delay(duration.toLong())
            popularityText.text = "${StatusModel.popularity}/10"
            popularityProgress.visibility = View.INVISIBLE
            popularityText.visibility = View.VISIBLE
            showBrewResults()
        }
    }

    private fun showBrewResults() {
        thread = GlobalScope.async {
            delay(duration.toLong())
            brewText.text = "${StatusModel.drinks}"
            brewProgress.visibility = View.INVISIBLE
            brewText.visibility = View.VISIBLE
            showProductResults()
        }
    }

    private fun showProductResults() {
        thread = GlobalScope.async {
            delay(duration.toLong())
            salesText.text = StatusModel.sales.toString()
            salesProgress.visibility = View.INVISIBLE
            salesText.visibility = View.VISIBLE
            showProfitResults()
        }
    }

    private fun showProfitResults() {
        thread = GlobalScope.async {
            delay(duration.toLong())
            profitProgress.visibility = View.INVISIBLE
            profitText.visibility = View.VISIBLE
            balanceProgress.visibility = View.INVISIBLE
            balanceText.visibility = View.VISIBLE
        }
    }

    private fun checkBalance() {
        if (StatusModel.balance < 0) {
            nextButton.text = "Click to Finish Game"
        }
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.weatherButton).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_summaryFragment_to_weatherFragment)
        }
        view.findViewById<Button>(R.id.popularityButton).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_summaryFragment_to_popularityFragment)
        }
        view.findViewById<Button>(R.id.brewButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_summaryFragment_to_makeFragment)
        }
        view.findViewById<Button>(R.id.salesButton).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_summaryFragment_to_salesFragment)
        }
        view.findViewById<Button>(R.id.profitButton).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_summaryFragment_to_profitFragment)
        }
    }

    fun onPlanClick(view: View) {
        if (StatusModel.balance > 0) {
            SetupHelper.nextMonth()
            SetupHelper.setSeason(StartApp.instance)
            SetupHelper.setHeader()
        } else {

        }
    }

}
