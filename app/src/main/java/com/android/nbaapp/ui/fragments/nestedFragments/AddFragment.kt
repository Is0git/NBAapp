package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.android.nbaapp.data.vms.AddFragmentViewmodel
import com.android.nbaapp.data.vms.ViewModelFactory
import com.android.nbaapp.databinding.AddFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AddFragment : DaggerFragment(){
    @Inject lateinit var viewmodelFactory: ViewModelFactory
    lateinit var viewmodel:AddFragmentViewmodel
    lateinit var binding:AddFragmentBinding
    lateinit var navigation: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddFragmentBinding.inflate(inflater,container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigation = Navigation.findNavController(view)
    }

    fun onAddClick(view: View) {
        if (binding.titleText.text.toString().isNotBlank()
            && binding.descriptionText.text.toString().isNotBlank()
            && binding.imageUrlText.text.toString().isNotBlank()
        ) {

        }
    }
}