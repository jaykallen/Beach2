package com.jaykallen.beach2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jaykallen.beach2.R
import com.jaykallen.beach2.helper.Helper
import com.jaykallen.beach2.model.StatusModel
import kotlinx.android.synthetic.main.fragment_plan.*



class PlanFragment : Fragment() {
    var total = 0L

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_plan, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Plan Fragment *******************")
        setupSeekBar()
        setupButtons(view!!)
    }

    private fun setupSeekBar() {
        makeSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                makeText.text = progress.toString()
                calcTotal()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })
        fruitSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                fruitText.text = (progress * 10).toString()
                calcTotal()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })
        adSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                adText.text = progress.toString()
                calcTotal()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })
        priceSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                priceText.text = (progress / 10).toString()
                calcTotal()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })

    }

    private fun calcTotal() {
        val barrels: Int = makeSeek.progress
        val fruit: Int = fruitSeek.progress
        val ads: Int = adSeek.progress
        val price: Int = priceSeek.progress
        total = barrels * 100 + fruit * 3 + ads * 50L + 600
        costText.text = total.toString()
    }

    private fun updateModel() {
        StatusModel.expenses = total.toFloat()
        StatusModel.drinks = 100 * makeSeek.progress
        StatusModel.fruits = 3 * fruitSeek.progress
        StatusModel.ads = adSeek.progress.toFloat()
        StatusModel.price = priceSeek.progress.toFloat()
        Helper.setResults()
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.startButton).setOnClickListener {
            if (StatusModel.balance > total) {
                updateModel()
                Navigation.findNavController(view)
                    .navigate(R.id.action_planFragment_to_summaryFragment)
            } else {
                Toast.makeText(activity, "Not enough balance for this", Toast.LENGTH_LONG).show()
            }
        }
    }

}
