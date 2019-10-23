package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.android.nbaapp.R
import com.android.nbaapp.data.vms.HomeViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.HomeFragmentBinding
import com.android.nbaapp.ui.activities.MainActivity
import com.android.nbaapp.ui.adapters.ViewPagerAdapter
import com.android.nbaapp.utils.FragmentsComs
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior
import com.google.android.material.bottomappbar.BottomAppBar
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment(), FragmentsComs {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var navigator: NavController
    lateinit var homeViewModel: HomeViewModel
    lateinit var binding: HomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        homeViewModel =
            ViewModelProviders.of(activity!!, viewModelFactory).get(HomeViewModel::class.java)
        setupTabLayout()

        binding.bar.setOnMenuItemClickListener {
            if (it.itemId == R.id.home) homeViewModel.deleteAllNews()
            true
        }

        binding.fab.setOnClickListener { navigator.navigate(R.id.action_homeFragment_to_addFragment) }

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
        //Pass interface to activity -> fragments
        (activity as MainActivity).fragmentsComs = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigator = Navigation.findNavController(view)
    }

    private fun setupTabLayout() {
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    private fun removeFabOnSecondChildFragment(position: Int) {
        if (position == 0) {
            binding.fab.show()
            binding.bar.hideOnScroll
            binding.bar.replaceMenu(R.menu.menu)
        } else {
            binding.fab.hide()
            showBottomBar()
            binding.bar.replaceMenu(R.menu.menu2)
        }
    }

    override fun hideBottomBar() {
        binding.bar.visibility = INVISIBLE
        binding.fab.hide()
    }

    override fun showBottomBar() {
        binding.bar.visibility = VISIBLE
        binding.fab.show()
    }
}