package com.malygos.gnemes.data.network

import android.util.Log
import com.malygos.gnemes.data.entity.MemePost
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.File

interface GnemesApiService {
    @GET(END_POINT_URL)
    suspend fun getMemePostsAsync():Response<List<MemePost>>


    
    companion object{
        private val DOMAIN_INTERNET:String by lazy {
            if (isUsingSimulator()) "http://10.0.2.2:8080/" else "http://192.168.1.96:8080"
        }
        //http://localhost:8080/api/v1/gnemes/memes
        const val END_POINT_URL:String ="/api/v1/gnemes/memes"
        private val known_pipes = arrayOf("/dev/socket/qemud", "/dev/qemu_pipe")
        private fun isUsingSimulator(): Boolean {
            for (i in known_pipes.indices) {
                val pipes = known_pipes[i]
                val qemuSocket = File(pipes)
                if (qemuSocket.exists()) {
                    Log.v("Result:", "Find pipes!")
                    return true
                }
            }
            Log.i("Result:", "Not Find pipes!")
            return false
        }

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
        public val gnemesApiService: GnemesApiService by lazy{
             Retrofit.Builder()
                .client(mClient)
                .baseUrl(DOMAIN_INTERNET)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GnemesApiService::class.java)
        }
    }
}