package com.jaykallen.beach2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jaykallen.beach2.R

// JK 2019-12-09: Attempt to use Room db in Sandbox environment to put into Manage Right later.

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("***************** Home Fragment *******************")
        setupButtons(view!!)
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.startButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_planFragment)
        }
    }
}
