package com.malygos.gnemes.ui.activity.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.data.repository.MemePostRepository
import kotlinx.coroutines.launch


class MemeDetailViewModel(
    val memePostRepository: MemePostRepository
) : ViewModel() {
    fun getMemePostById(id:String)=memePostRepository.getMemePostById(id)
}