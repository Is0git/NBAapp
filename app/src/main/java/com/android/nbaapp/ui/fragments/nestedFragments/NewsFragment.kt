package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.android.nbaapp.R
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.data.vms.NewsViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.NewsFragmentBinding
import com.android.nbaapp.ui.activities.MainActivity
import com.android.nbaapp.ui.adapters.NewsListAdapter
import com.android.nbaapp.ui.adapters.RecentGamesAdapter
import com.android.nbaapp.utils.FragmentsComs
import com.android.nbaapp.utils.listeners.NewsClickHandler
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewsFragment : DaggerFragment(), NewsClickHandler<NewsEntity> {

    private lateinit var newsViewModel: NewsViewModel
    lateinit var binding: NewsFragmentBinding
    @Inject
    lateinit var factory: ViewModelFactory
    @Inject
    lateinit var viewPagerAdapter: RecentGamesAdapter
    @Inject
    lateinit var newsListAdapter: NewsListAdapter

    lateinit var navigator: NavController

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

        newsListAdapter.onClickInterface = this

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigator = Navigation.findNavController(view)
    }

    override fun onNewsClick(data: NewsEntity) {
        navigator.navigate(R.id.singleNewsFragment)
    }

}