package com.malygos.gnemesuser.security.jwt

import com.malygos.gnemesuser.domin.GnemesUser
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtParser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import kotlin.collections.HashMap


@Component
class JWTUtil {
    val secret = "abcdefghijkmnYUIO+KLJHGHUIO*GYIUOLKJJHFYIUO$%&'()".toByteArray()

    @Autowired
    lateinit var jwtParser: JwtParser

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun jwtParser(): JwtParser {
        return Jwts.parserBuilder()
                .setSigningKey(Base64.getEncoder().encodeToString(secret))
                .build()
    }

    fun generateToken(user: GnemesUser): String {
        val now = Date()
        val expireDays = LocalDate.now().plusDays(7)
        val claim = HashMap<String, Any>()
        claim.put("alg", "HS256")
        claim.put("type", "JWT")
        return Jwts.builder()
                .setSubject(user.email)
                .setIssuedAt(now)
                .setExpiration(convertToDateViaInstant(expireDays))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secret))
                .setHeaderParams(claim)
                .compact()

    }

    fun getClaimsFromTokens(token: String): Claims {
        return jwtParser.parseClaimsJws(token).body
    }

    fun getUserEmailFromToken(token: String): String {
        return getClaimsFromTokens(token).subject
    }

    fun getExpirationDateFromToken(token: String): Date {
        return getClaimsFromTokens(token).expiration
    }

    fun isTokenExpired(token: String): Boolean {
        val expirationDate = getExpirationDateFromToken(token)
        return expirationDate.after(Date())
    }

    fun isTokenValidated(token: String): Boolean {
        return isTokenExpired(token)
    }

    fun convertToDateViaInstant(dateToConvert: LocalDate): Date? {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant())
    }
}