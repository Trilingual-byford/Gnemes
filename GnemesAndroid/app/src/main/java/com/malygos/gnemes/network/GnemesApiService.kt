package com.malygos.gnemes.network

import com.malygos.gnemes.data.entity.MemePost
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GnemesApiService {
    @GET
    suspend fun getMemePosts():Response<List<MemePost>>

    companion object{
        const val DOMAIN:String="http://127.0.0.1:8080"
        const val END_POINT_URL:String="/api/v1/gnemes/post"
        const val BASE_URL= DOMAIN+ END_POINT_URL
        operator fun invoke():GnemesApiService{
            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(requestInterceptor)
//                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GnemesApiService::class.java)
        }
    }
}