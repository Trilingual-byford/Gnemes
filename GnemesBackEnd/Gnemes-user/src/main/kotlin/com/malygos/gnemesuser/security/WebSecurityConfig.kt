package com.malygos.gnemesuser.security

import com.malygos.gnemesuser.services.GnemesUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.web.reactive.config.EnableWebFlux

@Configuration
@EnableWebFluxSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var gnemesUserService: GnemesUserService
    lateinit var AuthEntry
}