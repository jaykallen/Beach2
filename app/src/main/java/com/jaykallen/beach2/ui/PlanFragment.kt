package com.jaykallen.beach2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jaykallen.beach2.R
import kotlinx.android.synthetic.main.fragment_plan.*



class PlanFragment : Fragment() {

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
                fruitText.text = progress.toString()
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
                priceText.text = progress.toString()
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
        costText.text = (barrels + fruit + ads + price + 600).toString()
    }

    private fun calcBalance() {
        // todo figure out if costText is less than Balance.  If so then proceed, otherwise stop
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.startButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_planFragment)
        }
    }

}
