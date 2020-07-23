package com.malygos.gnemesuser.repository

import com.malygos.gnemesuser.domin.GnemesUser
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GnemesUserRepository: MongoRepository<GnemesUser, String>{
    fun findByEmail():GnemesUser
    fun existsByEmail(email:String):Boolean
}