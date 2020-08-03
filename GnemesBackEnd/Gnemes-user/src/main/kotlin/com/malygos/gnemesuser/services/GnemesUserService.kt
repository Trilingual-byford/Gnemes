package com.malygos.gnemesuser.services

import com.malygos.gnemesuser.domin.GnemesUser
import com.malygos.gnemesuser.repository.GnemesUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class GnemesUserService() {
    @Autowired
    lateinit var gnemesUserRepository: GnemesUserRepository
    fun registerGnemes(gnemesUser: GnemesUser): Mono<GnemesUser> {
        return gnemesUserRepository.insert(gnemesUser)
    }

    fun findAllGnemesUser(): Flux<GnemesUser> {
        return gnemesUserRepository.findAll()
    }

    fun findGnemesUserByEmail(email: String): Mono<GnemesUser> {
        return gnemesUserRepository.findByEmail(email)
    }

}