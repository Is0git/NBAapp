package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.data.vms.NewsViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.NewsFragmentBinding
import com.android.nbaapp.ui.adapters.RecentGamesAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewsFragment : DaggerFragment() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: NewsFragmentBinding
    @Inject
    lateinit var factory: ViewModelFactory
    @Inject
    lateinit var viewPagerAdapter: RecentGamesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        newsViewModel = ViewModelProviders.of(activity!!, factory).get(NewsViewModel::class.java)
        binding.gamesViewPager.adapter = viewPagerAdapter
        newsViewModel.data.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "RES : ${it?.data?.get(0)?.date}")
            viewPagerAdapter.setData(it)
        })
        return binding.root
    }
}