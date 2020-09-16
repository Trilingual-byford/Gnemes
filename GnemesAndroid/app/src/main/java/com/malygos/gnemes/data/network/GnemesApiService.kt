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
        val DOMAIN_INTERNET:String by lazy {
            if (checkPipes()) "http://10.0.2.2:9091/" else "http://127.0.0.1:9091/"
        }

        const val END_POINT_URL:String ="gnemes/api/post/v1/"
        private val known_pipes = arrayOf("/dev/socket/qemud", "/dev/qemu_pipe")
        fun checkPipes(): Boolean {
            for (i in known_pipes.indices) {
                val pipes = known_pipes[i]
                val qemu_socket = File(pipes)
                if (qemu_socket.exists()) {
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