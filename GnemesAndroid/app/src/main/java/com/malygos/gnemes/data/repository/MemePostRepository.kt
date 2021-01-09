package com.malygos.gnemes.data.repository

import com.malygos.gnemes.data.entity.ApiResponse
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.data.network.GnemesApiService
import com.malygos.gnemes.data.persistence.MemeDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MemePostRepository(
    private val gnemesApiService: GnemesApiService,
    private val memeDataBase: MemeDataBase
) : SafeApiRequest() {
    suspend fun getAllMemePost() = withContext(Dispatchers.IO) {
        println("getAllMemePost            : I'm working in thread ${Thread.currentThread().name}")
        var memeResult=ApiResponse<List<MemePost>>()
        val allMemePost = memeDataBase.posterDao().getAllMemePost()
//        if (allMemePost.isEmpty()) {
            val response = gnemesApiService.getMemePostsAsync()
//                response.body()?.let { memeDataBase.posterDao().insertMemePostList(it) }
                memeResult=ApiResponse<List<MemePost>>(response)
//        }else{
//            memeResult=ApiResponse<List<MemePost>>(allMemePost)
//        }
        memeResult
    }
    fun getMemePostById(id:String)=memeDataBase.posterDao().getMemePost(id)

}