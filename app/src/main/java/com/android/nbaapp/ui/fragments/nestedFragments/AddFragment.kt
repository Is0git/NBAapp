package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.nbaapp.databinding.AddFragmentBinding
import dagger.android.support.DaggerFragment

class AddFragment : DaggerFragment(){
    lateinit var binding:AddFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddFragmentBinding.inflate(inflater,container, false)
        return binding.root
    }
}