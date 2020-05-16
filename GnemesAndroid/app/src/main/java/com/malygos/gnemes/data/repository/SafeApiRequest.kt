package com.malygos.gnemes.data.repository

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    suspend fun<T> apiRequest(call:suspend ()->Response<T>):T{
        val response = call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else{
            throw ApiException(response.errorBody()!!.string())
        }

    }
}
class ApiException(message:String):IOException(message)