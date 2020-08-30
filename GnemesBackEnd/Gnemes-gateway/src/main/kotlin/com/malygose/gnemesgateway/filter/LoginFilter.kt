package com.malygose.gnemesgateway.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class LoginFilter:ZuulFilter() {
    @Autowired
    var stringRedisTemplate: StringRedisTemplate? = null

    companion object{
        const val TYPE_PRE="pre"
    }
    override fun run(): Any? {
        val currentContext = RequestContext.getCurrentContext()
        val request = currentContext.request
        val header = request.getHeader("Authorization")
        System.out.println("stringRedisTemplate:"+stringRedisTemplate?.connectionFactory)
        stringRedisTemplate?.opsForValue()?.set("LoginFilter","My first cache from Sb")
        if (header.isNullOrEmpty()){
            return null

        }
        return null
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return TYPE_PRE
    }

    override fun filterOrder(): Int {
        return 0
    }
}