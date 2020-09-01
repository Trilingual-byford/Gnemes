package com.malygos.gnemesuser.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisTokenService {
    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate

    fun cacheToken(userEmail:String,token:String){
        return stringRedisTemplate.boundValueOps(userEmail).set(token,7,TimeUnit.DAYS)
    }

    fun deleteToken(userEmail: String): Boolean {
        return stringRedisTemplate.delete(userEmail)
    }
    fun getTokenByEmail(userEmail: String): String? {
        return stringRedisTemplate.opsForValue().get(userEmail)
    }
}