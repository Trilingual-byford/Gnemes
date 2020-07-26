package com.malygos.gnemesuser.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextImpl
import org.springframework.security.web.server.context.ServerSecurityContextRepository
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.lang.UnsupportedOperationException
import java.util.*

@Component
class SecurityContextRepository:ServerSecurityContextRepository {
    @Autowired
    lateinit var authenticationManager: AuthenticationManager
    override fun save(exchange: ServerWebExchange?, context: SecurityContext?): Mono<Void> {
        throw UnsupportedOperationException("Not supported yet")
    }

    override fun load(exchange: ServerWebExchange?): Mono<SecurityContext> {
        val bearer="Bearer "
        val authHeader = exchange!!.request.headers.getFirst(HttpHeaders.AUTHORIZATION)
        var authToken=""
        if(authHeader!=null&&authHeader.startsWith(bearer)){
            authHeader.replace(bearer,"")
        }else{
            println("could not find bearer string,will ignore the header-------")
        }
        if(authHeader.isNullOrEmpty()){
            return Mono.empty()
        }else{
            val auth = UsernamePasswordAuthenticationToken(authToken, authToken)
            return this.authenticationManager.authenticate(auth).map { authentication: Authentication? -> SecurityContextImpl(authentication) }
        }
//        return Mono.
//        justOrEmpty(authHeader)
//                .log()
//                .filter { it.startsWith(bearer) }
//                .map { it.substring(bearer.length) }
//                .flatMap { Mono.just(UsernamePasswordAuthenticationToken(it,it, Collections.singletonList(SimpleGrantedAuthority("ROLE_USER")))) }
//                .flatMap { auth -> authenticationManager.authenticate(auth)
//                        .map { itMap->SecurityContextImpl(itMap)}  }
    }
}