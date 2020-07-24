package com.malygos.gnemesuser.security

import com.malygos.gnemesuser.repository.GnemesUserRepository
import com.malygos.gnemesuser.security.jwt.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
@Component
class AuthenticationManager:ReactiveAuthenticationManager {
    @Autowired
    lateinit var jwtUtil: JWTUtil
    @Autowired
    lateinit var gnemesUserRepository: GnemesUserRepository
    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        val token = authentication.credentials.toString()
        val email = jwtUtil.getUserEmailFromToken(token)
        return gnemesUserRepository.findByEmail(email)
                .flatMap { gnemesUser ->
                    return@flatMap if(jwtUtil.isTokenValidated(token)){
                        Mono.just(authentication)
                    }else{
                        Mono.empty()
                    }
                 }
    }
}