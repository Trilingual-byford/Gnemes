package com.malygos.gnemesuser.controller

import com.malygos.gnemesuser.domin.GnemesUser
import com.malygos.gnemesuser.dto.UserLoginDto
import com.malygos.gnemesuser.dto.UserRegisterDto
import com.malygos.gnemesuser.security.jwt.JWTUtil
import com.malygos.gnemesuser.services.GnemesUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Component
class GnemesUserAuthHandler {
    @Autowired
    lateinit var gnemesUserService: GnemesUserService
    @Autowired
    lateinit var jwtUtil: JWTUtil
    fun findAllUser(serverRequest:ServerRequest): Mono<ServerResponse> {
        val gnemesUser = gnemesUserService.findAllGnemesUser()
        return ServerResponse.ok().body(gnemesUser,GnemesUser::class.java)
    }
    fun findUserByEmail(serverRequest:ServerRequest): Mono<ServerResponse> {
        val email = serverRequest.pathVariable("email")
        return gnemesUserService.findGnemesUserByEmail(email)
                .flatMap { user->ServerResponse.ok().bodyValue(user)}
                .switchIfEmpty(ServerResponse.notFound().build())
    }
    fun registerUser(serverRequest: ServerRequest):Mono<ServerResponse>{
        val gnemesUser = serverRequest.bodyToMono(UserRegisterDto::class.java)
                .log()
                .flatMap {
                    val listOf = setOf(SimpleGrantedAuthority("admin"))
                    GnemesUser(listOf, it.email, it.password, it.userName).toMono()
                }.flatMap { user ->
                    gnemesUserService.registerGnemes(user)
                }
        return ServerResponse.status(HttpStatus.CREATED).body(gnemesUser,GnemesUser::class.java)
    }
    fun getToken(serverRequest: ServerRequest):Mono<ServerResponse>{
        val userMono = serverRequest.bodyToMono(UserLoginDto::class.java)
        var userPwd=""
        return userMono.flatMap { user->
            userPwd=user.password
            gnemesUserService.findGnemesUserByEmail(user.email)
            }
                .flatMap { userDetail->
                    if (userDetail.password.equals(userPwd)){
                        return@flatMap ServerResponse.ok().bodyValue(jwtUtil.generateToken(userDetail))
                    }else{
                        return@flatMap ServerResponse.badRequest().build()
                    }
                }
                .switchIfEmpty(ServerResponse.badRequest().bodyValue("hahahha"))
    }

}