package com.malygos.gnemesuser.security.jwt

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse

@Component
class JWTUtil {
    val secret:String="abcdefghijkmnYUIO+KLJHGHUIO*GYIUOLKJJHFYIUO$%&'()"
    val expireTimeInMiliSec="30000"
    fun generateToken(){

    }
}