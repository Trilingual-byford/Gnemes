package com.malygos.gnemesuser.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class GnemesUserAuthRouter {
    @Bean
    fun root(handler: GnemesUserAuthHandler):RouterFunction<ServerResponse>{
        return RouterFunctions.route()
                .GET("/api/v1/gnemes/auth",handler::findAllUser)
                .POST("/api/v1/gnemes/auth",handler::registerUser)
                .GET("/api/v1/gnemes/auth/{email}",handler::findUserByEmail)
                .POST("/api/v1/gnemes/auth/token",handler::getToken)
                .build()
    }

}