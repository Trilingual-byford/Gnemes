package com.malygos.gnemesuser.filters

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.stereotype.Component
import org.springframework.web.filter.CorsFilter
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Component
class AuthFilter: GenericFilterBean() {
    override fun initFilterBean() {

    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        println("DoFilter"+request.toString())
        chain?.doFilter(request,response)
    }


}