package com.malygos.gnemesuser.controller

import com.malygos.gnemesuser.domin.GnemesUser
import com.malygos.gnemesuser.dto.UserLoginDto
import com.malygos.gnemesuser.dto.UserRegisterDto
import com.malygos.gnemesuser.security.jwt.JWTUtil
import com.malygos.gnemesuser.services.GnemesUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Component
class GnemesUserAuthHandlerRouter {
    @Autowired
    lateinit var gnemesUserService: GnemesUserService

    @Autowired
    lateinit var jwtUtil: JWTUtil

    @PreAuthorize("hasAnyRole('ROLE_GOD','ROLE_USER')")
    fun findAllUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        val gnemesUser = gnemesUserService.findAllGnemesUser()
        return ServerResponse.ok().body(gnemesUser, GnemesUser::class.java)
    }

    fun findUserByEmail(serverRequest: ServerRequest): Mono<ServerResponse> {
        val email = serverRequest.pathVariable("email")
        return gnemesUserService.findGnemesUserByEmail(email)
                .flatMap { user -> ServerResponse.ok().bodyValue(user) }
                .switchIfEmpty(ServerResponse.notFound().build())
    }

    @PreAuthorize("permitAll()")
    fun registerUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(UserRegisterDto::class.java)
                .log()
                .flatMap {
                    GnemesUser(it.email, it.password, it.userName).toMono()
                }.flatMap { user ->
                    gnemesUserService.registerGnemes(user)
                }.flatMap {
                    return@flatMap ServerResponse.status(HttpStatus.CREATED).bodyValue(it)
                }.onErrorResume { ex ->
                    val message = ex.localizedMessage
                    ServerResponse.badRequest().bodyValue(message)
                }.switchIfEmpty(ServerResponse.notFound().build())
    }

    @PreAuthorize("permitAll()")
    fun getToken(serverRequest: ServerRequest): Mono<ServerResponse> {
        val userMono = serverRequest.bodyToMono(UserLoginDto::class.java)
        var userPwd = ""
        return userMono.flatMap { user ->
            userPwd = user.password
            gnemesUserService.findGnemesUserByEmail(user.email)
        }
                .flatMap { userDetail ->
                    if (userDetail.password.equals(userPwd)) {
                        return@flatMap ServerResponse.ok().bodyValue(jwtUtil.generateToken(userDetail))
                    } else {
                        return@flatMap ServerResponse.badRequest().build()
                    }
                }
                .switchIfEmpty(ServerResponse.notFound().build())
    }

    //    @PreAuthorize("hasAnyRole('ROLE_GOD','ROLE_USER')")
//    fun addCollection(serverRequest: ServerRequest): Mono<ServerResponse> {
//        val id = serverRequest.pathVariable("gnemesId")
//        return Mono.just(id).flatMap {
////            gnemesUserService
//        }
    @PreAuthorize("permitAll()")
    fun addCollection(serverRequest: ServerRequest): Mono<ServerResponse> {
        val PATH_VARIABLE_EMAIL = "email"
        val email = serverRequest.headers().header(PATH_VARIABLE_EMAIL).first()
        val gnemesId = serverRequest.headers().header("gnemes-id").first()
        return if (gnemesUserService.addCollection(email, gnemesId)) {
            ServerResponse.ok().bodyValue("Save collection successfully")
        } else {
            ServerResponse.badRequest().bodyValue("Save collection Fail")
        }
    }

    @Bean
    fun root(handler: GnemesUserAuthHandlerRouter): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
                .POST("/api/v1/gnemes/auth/token", handler::getToken)
                .POST("/api/v1/gnemes/auth", handler::registerUser)
                .GET("/api/v1/gnemes/administration/{email}", handler::findUserByEmail)
                .GET("/api/v1/gnemes/administration", handler::findAllUser)
                .PATCH("/api/v1/gnemes/collection", handler::addCollection)
                .build()
    }
}