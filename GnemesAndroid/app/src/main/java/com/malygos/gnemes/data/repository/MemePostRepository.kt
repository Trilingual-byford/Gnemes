package com.malygos.gnemes.data.repository

import com.malygos.gnemes.data.entity.ApiResponse
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.data.network.GnemesApiService
import retrofit2.Response
import java.lang.Exception

class MemePostRepository(private val gnemesApiService: GnemesApiService):SafeApiRequest() {
    suspend fun getAllMemePostThroughApi(): ApiResponse<List<MemePost>> {
            return ApiResponse<List<MemePost>>(gnemesApiService.getMemePostsAsync())
    }
}