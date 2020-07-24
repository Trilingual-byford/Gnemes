package com.malygos.gnemesuser.repository

import com.malygos.gnemesuser.domin.GnemesUser
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface GnemesUserRepository: ReactiveMongoRepository<GnemesUser, String>{
    fun findByEmail(email:String): Mono<GnemesUser>
    fun existsByEmail(email:String):Boolean
}