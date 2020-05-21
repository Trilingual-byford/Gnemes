package com.malygos.gnemes.ui.fragment.post

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malygos.gnemes.data.entity.ApiResponse
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.data.repository.MemePostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

class NewPostViewModel(
    val memePostRepository: MemePostRepository
) : ViewModel() {
    val memePost=MutableLiveData<ApiResponse<List<MemePost>>>()
    init {
        viewModelScope.launch{
            getAllMemePosts()
        }
    }
     suspend fun getAllMemePosts() {
        runBlocking {
            try {
                val allMemePostThroughApi = memePostRepository.getAllMemePostThroughApi()
                memePost.value=allMemePostThroughApi
            }catch (e:Exception){
                memePost.value=(ApiResponse<List<MemePost>>(Exception(e)))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("onCleared","NewPostViewModel")
    }
}