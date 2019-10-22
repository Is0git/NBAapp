package com.android.nbaapp.ui.fragments.nestedFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.android.nbaapp.data.db.enitities.NewsEntity
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
        viewmodel = ViewModelProviders.of(activity!!, viewmodelFactory)
            .get(AddFragmentViewmodel::class.java)
        binding.add.setOnClickListener { onAddClick(it) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigation = Navigation.findNavController(view)
    }

    fun onAddClick(view: View) {
        Log.d("TAG", "TRIGGERED")
        val title = binding.titleText.text.toString()
        val description = binding.descriptionText.text.toString()
        val image_url = binding.imageUrlText.text.toString()
        if (title.isNotBlank() && description.isNotBlank() && image_url.isNotBlank()) viewmodel.addNews(
            NewsEntity(title, image_url, description)
        ).also { navigation.navigateUp() }
        else Toast.makeText(context, "FILL ALL FIELDS", Toast.LENGTH_LONG).show()
    }
}