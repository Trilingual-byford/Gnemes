package com.malygos.gnemes.ui.fragment.post

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.malygos.gnemes.R
import com.malygos.gnemes.data.network.GnemesApiService
import com.malygos.gnemes.data.network.GnemesApiService.Companion.gnemesApiService
import com.malygos.gnemes.data.persistence.MemeDataBase.Companion.getMemeDataBase
import com.malygos.gnemes.data.repository.MemePostRepository
import com.malygos.gnemes.databinding.NewPostFragmentBinding
import com.malygos.gnemes.ui.fragment.liked.LikedFragment
import com.malygos.gnemes.utils.InternetUtils
import kotlinx.android.synthetic.main.offline_layout_fragment.view.*


class NewPostFragment : Fragment() {

    private lateinit var viewModel: NewPostViewModel
    private lateinit var binding: NewPostFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentFragmentManager = getParentFragmentManager()
        binding = NewPostFragmentBinding.inflate(inflater, container, false)
        if (InternetUtils.hasNetworkAvailable(context)) {
            val repository = MemePostRepository(gnemesApiService,getMemeDataBase())
            viewModel = ViewModelProviders.of(this, NewPostViewModelFactory(repository))
                .get(NewPostViewModel::class.java)
            if (viewModel.memePost.value == null) {
                return binding.root
            }
            viewModel.memePost.observe(viewLifecycleOwner, Observer {
                if (it.isSuccessful) {
                    binding.recyclerMemePost.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.recyclerMemePost.adapter = MemePostsAdapter(parentFragmentManager,it.body!!)
                    val decoration = DividerItemDecoration(
                        context,
                        DividerItemDecoration.VERTICAL
                    )
                    decoration.setDrawable(requireContext().getDrawable(R.drawable.divider_recyclerview)!!)
                    binding.recyclerMemePost.addItemDecoration(decoration)
                } else {
                    binding.viewOffline.visibility=View.VISIBLE
                    binding.viewOffline.tv_detail_content.text=it.errorMessage
                    binding.recyclerMemePost.visibility=View.GONE
                }
            }
            )
        } else {
            binding.viewOffline.visibility=View.VISIBLE
            binding.recyclerMemePost.visibility=View.GONE
        }
        return binding.root
    }

    companion object {
        fun newInstance() = NewPostFragment()
    }

}