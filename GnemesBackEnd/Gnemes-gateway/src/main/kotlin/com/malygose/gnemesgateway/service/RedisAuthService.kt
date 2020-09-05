package com.malygose.gnemesgateway.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisAuthService {
    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate
    fun tokenCheck(email:String,token:String):Boolean{
        if(stringRedisTemplate.getExpire(token,TimeUnit.SECONDS)<0){
            return false
        }else{
            val tokenFromRedis = stringRedisTemplate.opsForValue().get(email)
            return tokenFromRedis.equals(token)
        }

    }
}