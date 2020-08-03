package com.malygos.gnemesuser

import com.malygos.gnemesuser.services.GnemesUserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.GrantedAuthority
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class GnemesUserApplicationTests {

    @Autowired
    lateinit var gnemesUserService: GnemesUserService

    //	@Autowired
//	lateinit var webTestClient: WebTestClient
    @Test
    fun findAllUser() {
//        Mockito.`when`(gnemesUserService.findAllGnemesUser())
//                .thenReturn()
        val findAllGnemesUser = gnemesUserService.findAllGnemesUser()
        val blockLast = findAllGnemesUser.blockLast()
        blockLast?.userName
//	GrantedAuthority

    }

    @Test
    fun contextLoads() {
    }

}
