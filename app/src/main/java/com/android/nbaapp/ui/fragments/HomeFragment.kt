package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.android.nbaapp.databinding.HomeFragmentBinding
import com.android.nbaapp.ui.adapters.ViewPagerAdapter

class HomeFragment : Fragment() {
    lateinit var binding:HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        setupTabLayout()
        return binding.root
    }

    fun setupTabLayout() {
        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager, FragmentPagerAdapter.POSITION_UNCHANGED)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}