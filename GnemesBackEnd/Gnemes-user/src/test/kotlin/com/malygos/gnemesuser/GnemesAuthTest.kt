package com.malygos.gnemesuser

import com.malygos.gnemesuser.services.GnemesUserService
import com.malygos.gnemesuser.services.RedisTokenService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class GnemesAuthTest {
    @Autowired
    lateinit var gnemesUserService: GnemesUserService
    @Autowired
    lateinit var redisService: RedisTokenService
//    @Autowired
//    lateinit var webTestClient: WebTestClient

    @Test
    fun findAllUser() {
//        Mockito.`when`(gnemesUserService.findAllGnemesUser())
//                .thenReturn()
        val findAllGnemesUser = gnemesUserService.findAllGnemesUser()
        val blockLast = findAllGnemesUser.blockLast()
        blockLast?.userName
    }
    @Test
    fun redisCacheTest(){
        redisService.cacheToken("heiheiei","hohoho")
    }
    @Test
    fun redisDelTest(){
        val result = redisService.deleteToken("heiheiei")
        check(result)
    }
    @Test
    fun getValueDelTest(){
        redisService.cacheToken("heiheiei","hohoho")
        val result = redisService.getTokenByEmail("heiheiei")
        println("-------------------------")
        println(result)
    }
    @Test
    fun getNullValueTest(){
        val result = redisService.getTokenByEmail("niconicocsc@gmail.com")
        println("-------------------------")
        println(result)
    }

}