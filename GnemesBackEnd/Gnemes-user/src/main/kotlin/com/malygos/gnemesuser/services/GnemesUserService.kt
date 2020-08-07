package com.malygos.gnemesuser.services

import com.malygos.gnemesuser.domin.GnemesUser
import com.malygos.gnemesuser.repository.GnemesUserRepository
import com.malygos.gnemesuser.repository.MongoDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class GnemesUserService() {

    @Autowired
    lateinit var gnemesUserRepository: GnemesUserRepository
    @Autowired
    lateinit var mongoDao: MongoDao
    @Autowired
    lateinit var mongoOperations: MongoOperations
    fun registerGnemes(gnemesUser: GnemesUser): Mono<GnemesUser> {
        return gnemesUserRepository.insert(gnemesUser)
    }

    fun findAllGnemesUser(): Flux<GnemesUser> {
        return gnemesUserRepository.findAll()
    }

    fun findGnemesUserByEmail(email: String): Mono<GnemesUser> {
        return gnemesUserRepository.findByEmail(email)
    }
    fun likeCollection(email:String, gnemesPostId:String):Boolean{
        return mongoDao.likeCollection(mongoOperations,gnemesPostId,email)
    }
    fun saveCollection(email:String, gnemesPostId:String):Boolean{
        return mongoDao.saveCollection(mongoOperations,gnemesPostId,email)
    }

}