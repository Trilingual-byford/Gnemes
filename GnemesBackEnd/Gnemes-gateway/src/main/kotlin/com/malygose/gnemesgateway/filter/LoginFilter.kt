package com.malygose.gnemesgateway.filter

import com.google.gson.GsonBuilder
import com.malygose.gnemesgateway.Response
import com.malygose.gnemesgateway.service.RedisAuthService
import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY
import org.springframework.stereotype.Component

@Component
class LoginFilter:ZuulFilter() {


    @Autowired
    lateinit var redisAuthService: RedisAuthService

    companion object{
        const val TYPE_PRE="pre"
        const val GNEMES_SERVICE="Gnemes"
        const val GNEMES_USER_SERVICE="GnemesUser"
        const val USER_TOKEN_URL="/user/v1/token"
        const val USER_LOGIN_URL="/user/v1/login"
        const val USER_REGISTER_URL="/user/v1/register"
    }
    override fun run(): Any? {
        val currentContext = RequestContext.getCurrentContext()
        val request = currentContext.request
        val serviceId = currentContext.get(SERVICE_ID_KEY)
        val requestURI = currentContext.get("requestURI")
        val token = request.getHeader("Authorization")
        val email = request.getHeader("Email")
        if(serviceId!=null){
            if (serviceId == GNEMES_SERVICE){
                return null
            }
            if(serviceId == GNEMES_USER_SERVICE){
                if(requestURI==USER_TOKEN_URL||requestURI==USER_LOGIN_URL||requestURI==USER_REGISTER_URL){
                    return null
                }
            }

        }

         if (token.isNullOrEmpty()||email.isNullOrEmpty()){
            denyAccess()
        }else if (redisAuthService.tokenCheck(email,token)){
            return null
        } else{
            denyAccess()
        }
        return null
    }

    override fun shouldFilter(): Boolean {
        val currentContext = RequestContext.getCurrentContext()
        return true
    }

    override fun filterType(): String {
        return TYPE_PRE
    }

    override fun filterOrder(): Int {
        return 6
    }
    fun denyAccess(){
        val currentContext = RequestContext.getCurrentContext()
        val response = currentContext.response
        currentContext.setSendZuulResponse(false)
        currentContext.responseStatusCode=200
        val responseBody = Response("Oops,You are unauthorized", 1002)
        val jsonBody = GsonBuilder().create().toJson(responseBody)
        currentContext.responseBody=jsonBody
        response.contentType="application/json;charset=utf-8"
    }
}