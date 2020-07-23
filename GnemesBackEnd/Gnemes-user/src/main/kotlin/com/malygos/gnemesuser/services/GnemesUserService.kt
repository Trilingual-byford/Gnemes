package com.malygos.gnemesuser.services

import com.malygos.gnemesuser.domin.GnemesUser
import com.malygos.gnemesuser.repository.GnemesUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GnemesUserService()  {
    @Autowired
    lateinit var gnemesUserRepository: GnemesUserRepository
    fun registerGnemes(gnemesUser: GnemesUser):GnemesUser{

    }

}