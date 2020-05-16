package com.malygos.gnemes.ui.fragment.post

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.malygos.gnemes.R
import com.malygos.gnemes.data.network.GnemesApiService
import com.malygos.gnemes.data.repository.MemePostRepository
import com.malygos.gnemes.databinding.NewPostFragmentBinding

class NewPostFragment : Fragment() {

    private lateinit var viewModel: NewPostViewModel
    private lateinit var binding:NewPostFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewPostFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val repository = MemePostRepository(GnemesApiService.invoke())
        viewModel = ViewModelProviders.of(this,NewPostViewModelFactory(repository)).get(NewPostViewModel::class.java)
        viewModel.memePost.observe(viewLifecycleOwner, Observer {
            binding.postData= it[0].dir
        })
    }

}