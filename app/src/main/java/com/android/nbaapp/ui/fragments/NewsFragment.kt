package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.data.vms.HomeViewModel
import com.android.nbaapp.databinding.NewsFragmentBinding

class NewsFragment : Fragment() {
    lateinit var homeViewModel: HomeViewModel
    lateinit var binding: NewsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        homeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
        homeViewModel.data.observe(viewLifecycleOwner, Observer { Log.d("TAG", "RES : ${it?.data?.get(0)?.date}") })
        return binding.root
    }
}