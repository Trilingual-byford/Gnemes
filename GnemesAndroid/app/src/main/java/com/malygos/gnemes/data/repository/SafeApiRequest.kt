package com.malygos.gnemes.data.repository

import android.util.Log
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

abstract class SafeApiRequest {

    suspend fun<T> apiRequest(call:suspend ()->Response<T>):T?{
        try {
            val response = call.invoke()
            if(response.isSuccessful){
                return response.body()!!
            }else{
                throw ApiException(response.errorBody()!!.string())
            }
        }catch (e:Exception){
            e.printStackTrace()
            throw ApiException(e.message?:"SafeApiRequestError")
        }

    }
}
class ApiException(message:String):IOException(message)