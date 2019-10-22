package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.data.vms.AllGamesViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.GamesFragmentBinding
import com.android.nbaapp.ui.adapters.GamesListAdapter
import com.android.nbaapp.ui.adapters.NewsListAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.games_fragment.*
import javax.inject.Inject

class GamesFragment : DaggerFragment() {
    @Inject lateinit var factory:ViewModelFactory
    lateinit var binding:GamesFragmentBinding
    lateinit var viewmodel:AllGamesViewModel
    lateinit var adapter:GamesListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GamesFragmentBinding.inflate(inflater, container, false)
        adapter = GamesListAdapter()
        binding.gamesRecyclerview.adapter = adapter
        viewmodel = ViewModelProviders.of(activity!!, factory).get(AllGamesViewModel::class.java)
        viewmodel.allGamespageList.observe(viewLifecycleOwner, Observer {adapter.submitList(it)})
        return binding.root
    }
}