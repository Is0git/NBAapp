package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.R
import com.android.nbaapp.data.vms.NewsViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.NewsFragmentBinding
import com.android.nbaapp.ui.adapters.NewsListAdapter
import com.android.nbaapp.ui.adapters.RecentGamesAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class NewsFragment : DaggerFragment() {
    private lateinit var newsViewModel: NewsViewModel
    lateinit var binding: NewsFragmentBinding
    @Inject
    lateinit var factory: ViewModelFactory
    @Inject
    lateinit var viewPagerAdapter: RecentGamesAdapter
    @Inject
    lateinit var newsListAdapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        binding.listRecyclerview.adapter = newsListAdapter
        newsViewModel = ViewModelProviders.of(activity!!, factory).get(NewsViewModel::class.java)
        binding.gamesViewPager.adapter = viewPagerAdapter

        newsViewModel.data.observe(viewLifecycleOwner, Observer {
            viewPagerAdapter.setData(it)
        })
//        newsViewModel.addNews(NewsEntity("Something", "https://thenypost.files.wordpress.com/2019/09/nba.jpg?quality=90&strip=all&w=618&h=410&crop=1", "Very importaant stuff"))
        newsViewModel.news.observe(viewLifecycleOwner, Observer {
            newsListAdapter.submitList(it)
        Log.d("BOD", "RES: $it")})


        return binding.root
    }

}