package com.malygos.gnemesuser.repository

import com.malygos.gnemesuser.domin.GnemesUser
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GnemesUserRepository: ReactiveMongoRepository<GnemesUser, Long>