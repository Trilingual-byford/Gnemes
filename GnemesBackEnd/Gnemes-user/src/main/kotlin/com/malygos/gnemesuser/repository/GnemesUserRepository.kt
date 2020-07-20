package com.malygos.gnemesuser.repository

import com.malygos.gnemesuser.domin.GnemesUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GnemesUserRepository:JpaRepository<GnemesUser,Long> {}