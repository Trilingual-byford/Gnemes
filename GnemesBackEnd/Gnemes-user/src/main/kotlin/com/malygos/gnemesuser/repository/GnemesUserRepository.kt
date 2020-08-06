package com.malygos.gnemesuser.repository

import com.malygos.gnemesuser.domin.GnemesUser
import com.mongodb.client.MongoClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface GnemesUserRepository : ReactiveMongoRepository<GnemesUser, String> {
    fun findByEmail(email: String): Mono<GnemesUser>
    fun existsByEmail(email: String): Boolean
}