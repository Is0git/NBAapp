package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.nbaapp.databinding.SingleNewsFragmentBinding

class SingleNewsFragment : Fragment() {
lateinit var binding:SingleNewsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SingleNewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}