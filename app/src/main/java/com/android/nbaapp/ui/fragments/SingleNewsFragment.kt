package com.android.nbaapp.ui.fragments

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.nbaapp.R
import com.android.nbaapp.databinding.SingleNewsFragmentBinding

class SingleNewsFragment : Fragment() {
lateinit var binding:SingleNewsFragmentBinding
lateinit var  position : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       position = arguments?.get("position").toString()

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SingleNewsFragmentBinding.inflate(inflater, container, false)
        binding.newsPhoto.transitionName = "imageTransition".plus(position)
        binding.newsTitle.transitionName = "titleTransition".plus(position)
        return binding.root
    }
}