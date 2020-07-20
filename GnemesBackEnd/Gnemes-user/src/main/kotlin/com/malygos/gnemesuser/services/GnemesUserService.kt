package com.malygos.gnemesuser.services

import com.malygos.gnemesuser.domin.GnemesUser

interface GnemesUserService {
    fun userRegister(gnemesUser: GnemesUser):GnemesUser

}