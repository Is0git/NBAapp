package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.R
import com.android.nbaapp.data.vms.HomeViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.HomeFragmentBinding
import com.android.nbaapp.ui.adapters.ViewPagerAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.*
import retrofit2.Retrofit
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    @Inject lateinit var viewModelFactory:ViewModelFactory
    lateinit var homeViewModel: HomeViewModel
    lateinit var binding:HomeFragmentBinding
//    @Inject lateinit var viewPagerAdapter: RecentGamesAdapter
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
        return binding.root
    }

    private fun setupTabLayout() {
        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager, FragmentPagerAdapter.POSITION_UNCHANGED)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}