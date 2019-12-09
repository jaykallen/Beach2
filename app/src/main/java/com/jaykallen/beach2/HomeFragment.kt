package com.jaykallen.beach2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// JK 2019-11-11: Attempt to use Room db in Sandbox environment to put into Manage Right later.

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Home Fragment *******************")
        setupButtons(view!!)
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.unitsButton).setOnClickListener {

        }
        view.findViewById<Button>(R.id.clearButton).setOnClickListener {

        }
    }



}
