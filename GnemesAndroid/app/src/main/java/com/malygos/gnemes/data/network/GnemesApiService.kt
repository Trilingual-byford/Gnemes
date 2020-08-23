package com.malygos.gnemes.data.network

import com.malygos.gnemes.data.entity.MemePost
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GnemesApiService {
    @GET(END_POINT_URL)
    suspend fun getMemePostsAsync():Response<List<MemePost>>

    companion object{
        const val DOMAIN_INTERNET:String="http:/192.168.100.32:9090"
        const val END_POINT_URL:String="api/v1/gnemes/post/"

        private val mInterceptor by lazy {
            Interceptor { chain ->
                val original = chain.request()
                    chain.proceed(
                        original.newBuilder()
                            .method(original.method, original.body)
                            .build()
                    )
            }
        }
        private val mClient by lazy {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(mInterceptor)
                .addInterceptor(logging)
                .build()
        }
        public val gnemesApiService by lazy{
             Retrofit.Builder()
                .client(mClient)
                .baseUrl(DOMAIN_INTERNET)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GnemesApiService::class.java)
        }
    }
}