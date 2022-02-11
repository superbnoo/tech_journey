package com.zuh.theapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.zuh.theapp.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * created by Sachin Rajput
 * https://droid-lover.medium.com/
 */



class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.cat_lovers -> {
                    mainNavHost.findNavController().navigate(R.id.catFunFactsFragment)
                }
                R.id.dog_lovers -> {
                    mainNavHost.findNavController().navigate(R.id.dogFunFactsFragment)
                }
            }
            true
        }


        bottom_navigation.setOnNavigationItemReselectedListener {

        }
    }


}