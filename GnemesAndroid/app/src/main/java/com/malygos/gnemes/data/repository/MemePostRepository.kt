package com.malygos.gnemes.data.repository

import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.data.network.GnemesApiService

class MemePostRepository(private val gnemesApiService: GnemesApiService):SafeApiRequest() {
    suspend fun getAllMemePostThroughApi(): List<MemePost> {
         return apiRequest{gnemesApiService.getMemePostsAsync()}
    }
}