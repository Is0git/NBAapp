package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.android.nbaapp.R
import com.android.nbaapp.data.vms.HomeViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.HomeFragmentBinding
import com.android.nbaapp.ui.adapters.ViewPagerAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    @Inject lateinit var viewModelFactory:ViewModelFactory
    @Inject
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var homeViewModel: HomeViewModel
    lateinit var binding:HomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
    homeViewModel = ViewModelProviders.of(activity!!, viewModelFactory ).get(HomeViewModel::class.java)
        setupTabLayout()
    binding.bar.setOnMenuItemClickListener {
        if (it.itemId == R.id.home) homeViewModel.deleteAllNews()
        true
    }

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                Log.d("CHANGED", "SDSD")
                removeFabOnSecondChildFragment(position)

            }
        })

        return binding.root
    }

    private fun setupTabLayout() {
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    private fun removeFabOnSecondChildFragment(position: Int) {
        if (position == 0) {
            binding.fab.show()
            binding.bar.replaceMenu(R.menu.menu)
        } else {
            binding.fab.hide()
            binding.bar.replaceMenu(R.menu.menu2)
        }


    }
}