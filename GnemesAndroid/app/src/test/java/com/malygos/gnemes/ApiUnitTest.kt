package com.malygos.gnemes

import com.malygos.gnemes.data.network.GnemesApiService
import org.junit.Test

class ApiUnitTest {
    @Test
    suspend fun getPostUnitTest(){
        val memePosts = GnemesApiService.invoke().getMemePostsAsync()
        memePosts.errorBody()
//        assert(memePosts!=null)
    }
}