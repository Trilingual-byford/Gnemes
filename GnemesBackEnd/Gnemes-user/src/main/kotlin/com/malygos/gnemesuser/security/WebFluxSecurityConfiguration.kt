package com.malygos.gnemesuser.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.savedrequest.NoOpServerRequestCache
import reactor.core.publisher.Mono

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity()
class WebFluxSecurityConfiguration {
    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var securityContextRepository: SecurityContextRepository

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(10)
    }

    @Bean
    fun filterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
                .authorizeExchange()
//                .pathMatchers(HttpMethod.POST,"/api/v1/gnemes/auth/token").permitAll()
//                .pathMatchers("/api/v1/gnemes/auth/token").permitAll()
                .anyExchange()
                .permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint { exchange, e ->
                    Mono.fromRunnable {
                        println(e)
                        exchange.response.setStatusCode(HttpStatus.UNAUTHORIZED)
                    }
                }
                .accessDeniedHandler { exchange, denied ->
                    Mono.fromRunnable {
                        exchange.response.setStatusCode(HttpStatus.FORBIDDEN)
                    }
                }
                .and()
                .httpBasic().disable()
                .cors().disable()
                .formLogin().disable()
                .csrf().disable()
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .requestCache().requestCache(NoOpServerRequestCache.getInstance())
                .and()
                .build()

    }
}