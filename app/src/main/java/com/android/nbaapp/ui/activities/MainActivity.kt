package com.android.nbaapp.ui.activities

import android.os.Bundle
import com.android.nbaapp.R
import com.android.nbaapp.utils.FragmentsComs
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    lateinit var fragmentsComs: FragmentsComs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
