package com.jaykallen.beach2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                makeText.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })

    }

    private fun calcTotal() {
        val barrels: Int = seekBar.progress

    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(com.jaykallen.beach2.R.id.startButton).setOnClickListener {
            Navigation.findNavController(view).navigate(com.jaykallen.beach2.R.id.action_homeFragment_to_planFragment)
        }
    }

}
