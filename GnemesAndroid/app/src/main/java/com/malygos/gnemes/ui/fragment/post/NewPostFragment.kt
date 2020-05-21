package com.malygos.gnemes.ui.fragment.post

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.malygos.gnemes.R
import com.malygos.gnemes.data.network.GnemesApiService
import com.malygos.gnemes.data.repository.MemePostRepository
import com.malygos.gnemes.databinding.NewPostFragmentBinding
import com.malygos.gnemes.utils.InternetUtils
import timber.log.Timber


class NewPostFragment : Fragment() {

    private lateinit var viewModel: NewPostViewModel
    private lateinit var binding:NewPostFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewPostFragmentBinding.inflate(inflater, container, false)
        if(InternetUtils.hasNetworkAvailable(context)){
            val repository = MemePostRepository(GnemesApiService.invoke())
            viewModel = ViewModelProviders.of(this,NewPostViewModelFactory(repository)).get(NewPostViewModel::class.java)
            if(viewModel.memePost.value==null){
                return binding.root
            }
            viewModel.memePost.observe(viewLifecycleOwner, Observer {
                Log.d("it.isSuccessful!!observe","observe")
                if(it.isSuccessful){
                    binding.recyclerMemePost.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                    binding.recyclerMemePost.adapter=MemePostsAdapter(it.body!!)
                    val decoration = DividerItemDecoration(
                        context,
                        DividerItemDecoration.VERTICAL
                    )
                    decoration.setDrawable(requireContext().getDrawable(R.drawable.divider_recyclerview)!!)
                    binding.recyclerMemePost.addItemDecoration(decoration)
                }else{
                    Log.d("it.isSuccessful!!",it.errorMessage)
                }
                }
          )
            return binding.root
        }else{
            return inflater.inflate(R.layout.ofline_layout_fragment, container, false)
        }
    }

}