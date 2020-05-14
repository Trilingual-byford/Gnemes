package com.malygos.gnemes.network

import com.malygos.gnemes.data.entity.MemePost
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GnemesApiService {
    @GET("api/v1/gnemes/post/")
    suspend fun getMemePostsAsync():Response<List<MemePost>>

    companion object{
        const val DOMAIN:String="http://localhost:8080"
        const val END_POINT_URL:String="/api/v1/gnemes/post/"
        const val BASE_URL= DOMAIN+ END_POINT_URL
        fun getInstance():GnemesApiService{
            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(requestInterceptor)
//                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://10.0.2.2:8080/")
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GnemesApiService::class.java)
        }
    }
}