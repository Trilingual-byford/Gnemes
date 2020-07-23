package com.malygos.gnemesuser.security.jwt

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint

class JwtAuthEntryPoint:AuthenticationEntryPoint {
    override fun commence(request: javax.servlet.http.HttpServletRequest?, response: javax.servlet.http.HttpServletResponse?, authException: AuthenticationException?) {
        TODO("Not yet implemented")
    }
}