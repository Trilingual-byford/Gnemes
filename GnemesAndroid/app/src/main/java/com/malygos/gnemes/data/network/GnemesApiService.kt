package com.malygos.gnemes.data.network

import com.malygos.gnemes.data.entity.MemePost
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GnemesApiService {
    @GET(END_POINT_URL)
    suspend fun getMemePostsAsync():Response<List<MemePost>>

    companion object{
        const val DOMAIN:String="http://10.0.2.2:8080/"
        const val END_POINT_URL:String="api/v1/gnemes/post/"
        const val BASE_URL= DOMAIN + END_POINT_URL
        operator fun invoke(): GnemesApiService {
            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(requestInterceptor)
//                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GnemesApiService::class.java)
        }
    }
}