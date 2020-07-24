package com.malygos.gnemesuser.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain
import reactor.core.publisher.Mono

@Configuration
@EnableWebFluxSecurity
class WebFluxSecurityConfiguration {
    @Bean
    fun userDetailsService():MapReactiveUserDetailsService{
        val userDetails= User.withDefaultPasswordEncoder()
                .username("wj")
                .password("password")
                .roles("USER")
                .build()
        return MapReactiveUserDetailsService(userDetails)
    }
    @Bean
    fun filterChain(http:ServerHttpSecurity):SecurityWebFilterChain{
        return http
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint{exchange, e -> Mono.fromRunnable{
                    exchange.response.setStatusCode(HttpStatus.OK)
                } }
                .accessDeniedHandler { exchange, denied -> Mono.fromRunnable {
                    exchange.response.setStatusCode(HttpStatus.FORBIDDEN)
                } }
                .and()
                .httpBasic(Customizer.withDefaults())
                .cors().disable()
                .formLogin().disable()
                .csrf().disable()
                .build()

    }
}