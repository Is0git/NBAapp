package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.android.nbaapp.R
import com.android.nbaapp.data.vms.NewsViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.NewsFragmentBinding
import com.android.nbaapp.ui.activities.MainActivity
import com.android.nbaapp.ui.adapters.NewsListAdapter
import com.android.nbaapp.ui.adapters.RecentGamesAdapter
import com.android.nbaapp.utils.FragmentsComs
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.news_fragment.*
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

    lateinit var fragmentsComs: FragmentsComs

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        binding.listRecyclerview.adapter = newsListAdapter

        fragmentsComs = (activity as MainActivity).fragmentsComs

        newsViewModel = ViewModelProviders.of(activity!!, factory).get(NewsViewModel::class.java)
        binding.gamesViewPager.adapter = viewPagerAdapter

        newsViewModel.data.observe(viewLifecycleOwner, Observer {
            viewPagerAdapter.setData(it)
        })
        newsViewModel.news.observe(viewLifecycleOwner, Observer {
            newsListAdapter.submitList(it)
        })


            binding.listRecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                       fragmentsComs.hideBottomBar()
                    } else if (dy < 0) {
                        fragmentsComs.showBottomBar()
                    }
                }
            })

            return binding.root
        }

}