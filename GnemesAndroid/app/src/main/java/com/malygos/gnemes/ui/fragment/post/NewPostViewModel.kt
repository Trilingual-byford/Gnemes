package com.malygos.gnemes.ui.fragment.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.data.repository.MemePostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewPostViewModel(
    val memePostRepository: MemePostRepository
) : ViewModel() {
    val memePost=MutableLiveData<List<MemePost>>()
    init {
        viewModelScope.launch{
            memePost.value=getAllMemePosts()
        }
    }
    suspend fun getAllMemePosts():List<MemePost>{
        return withContext(Dispatchers.IO){
            memePostRepository.getAllMemePostThroughApi()
        }
    }

}