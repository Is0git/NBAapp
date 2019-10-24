package com.android.nbaapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.R
import com.android.nbaapp.data.vms.SingleNewsViewModel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.SingleNewsFragmentBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.single_news_fragment.*
import javax.inject.Inject

class SingleNewsFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var binding: SingleNewsFragmentBinding
    lateinit var viewmodel: SingleNewsViewModel
    lateinit var position: String
    var id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = arguments?.get("position").toString()
        id = arguments?.getInt("id")
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmodel =
            ViewModelProviders.of(activity!!, viewModelFactory).get(SingleNewsViewModel::class.java)
        id?.let { viewmodel.setId(it) }
        binding = SingleNewsFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = activity
            viewModel = viewmodel
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.newsPhoto.transitionName = "imageTransition".plus(position)
            binding.newsTitle.transitionName = "titleTransition".plus(position)
        }

        binding.favoriteIcon.setOnClickListener { if(binding.viewModel?.data?.value?.isFavorite == false) viewmodel.setFavorite(true, id!!) else viewmodel.setFavorite(false, id!!) }
        return binding.root
    }
}