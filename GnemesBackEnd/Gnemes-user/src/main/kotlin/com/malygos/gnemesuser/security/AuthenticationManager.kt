package com.malygos.gnemesuser.security

import com.malygos.gnemesuser.repository.GnemesUserRepository
import com.malygos.gnemesuser.security.jwt.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.*

@Component
class AuthenticationManager : ReactiveAuthenticationManager {
    @Autowired
    lateinit var jwtUtil: JWTUtil

    @Autowired
    lateinit var gnemesUserRepository: GnemesUserRepository
    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        val token = authentication.credentials.toString()

        val email = if (token.isEmpty()) "" else jwtUtil.getUserEmailFromToken(token)
        return gnemesUserRepository.findByEmail(email)
                .flatMap { gnemesUser ->
                    return@flatMap if (jwtUtil.isTokenValidated(token)) {
                        val auth = UsernamePasswordAuthenticationToken(authentication.principal, authentication.credentials, gnemesUser.authorities) as Authentication
                        Mono.just(auth)
                    } else {
                        Mono.empty()
                    }
                }.switchIfEmpty(Mono.empty())
    }
}