package com.android.nbaapp.ui.fragments

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.App
import com.android.nbaapp.MainActivity
import com.android.nbaapp.data.vms.HomeViewModel
import com.android.nbaapp.databinding.NewsFragmentBinding
import com.android.nbaapp.di.mainActivity.ActivityContextQualifier
import com.android.nbaapp.ui.adapters.RecentGamesAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class NewsFragment : DaggerFragment() {
    lateinit var homeViewModel: HomeViewModel
    lateinit var binding: NewsFragmentBinding
    @Inject lateinit var viewPagerAdapter:RecentGamesAdapter
    @Inject lateinit var text:String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = NewsFragmentBinding.inflate(inflater, container, false)
        Log.d("TAG", "REsssS : $text")
        homeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
        homeViewModel.data.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "RES : ${it?.data?.get(0)?.date}")

            binding.gamesViewPager.adapter = viewPagerAdapter})
//        Log.d("TAG", "${viewPagerAdapter.count}")
        return binding.root
    }
}