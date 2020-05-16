package com.malygos.gnemes.ui.fragment.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.malygos.gnemes.data.repository.MemePostRepository

@Suppress("UNCHECKED_CAST")
class NewPostViewModelFactory(private val memePostRepository: MemePostRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NewPostViewModel::class.java)){
            return NewPostViewModel(memePostRepository) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}