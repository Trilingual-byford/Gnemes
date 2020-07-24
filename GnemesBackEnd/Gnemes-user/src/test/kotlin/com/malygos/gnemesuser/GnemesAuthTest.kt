package com.malygos.gnemesuser

import com.malygos.gnemesuser.services.GnemesUserService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
@SpringBootTest
class GnemesAuthTest {
    @Autowired
    lateinit var gnemesUserService: GnemesUserService
    @Autowired
    lateinit var webTestClient:WebTestClient
    @Test
    fun findAllUser(){
//        Mockito.`when`(gnemesUserService.findAllGnemesUser())
//                .thenReturn()
        val findAllGnemesUser = gnemesUserService.findAllGnemesUser()
        val blockLast = findAllGnemesUser.blockLast()
        blockLast?.userName

    }
}