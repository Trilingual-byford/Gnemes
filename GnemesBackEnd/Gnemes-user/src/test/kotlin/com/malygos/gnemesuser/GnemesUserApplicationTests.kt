package com.malygos.gnemesuser

import com.malygos.gnemesuser.services.GnemesUserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

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
    @Test
    fun saveCollection(){
        val addCollection = gnemesUserService.likeCollection("niconicocbf@gmail.com", "5f171cae765b1da3d508cf59")
        println(addCollection)
    }
}
