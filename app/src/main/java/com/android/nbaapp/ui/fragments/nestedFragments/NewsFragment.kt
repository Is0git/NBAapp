package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
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


    override fun onNewsClick(view1: View, view2: View, data: NewsEntity) {
        //Transition names has to be unique therefore we have to make unique names for recycler view shared elements views
        val extras = FragmentNavigatorExtras(view1 as ImageView to "${view1.transitionName}", view2 as TextView to "${view2.transitionName}")
        val regex = Regex("\\d+")
        val position = regex.find(view1.transitionName.toString())
        val bundle : Bundle? = Bundle().also {  it.putString("position", position?.value)}
        navigator.navigate(R.id.action_homeFragment_to_singleNewsFragment, bundle, null, extras)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SAATE", "NEWS DESTOY")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("SAATE", "NEWS VIEW DESTROY")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("SAATE", "NEWS DETACHED")
    }
}