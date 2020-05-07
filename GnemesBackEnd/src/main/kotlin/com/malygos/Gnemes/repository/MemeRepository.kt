package com.malygos.Gnemes.repository

import com.malygos.Gnemes.domain.MemePost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemeRepository: JpaRepository<MemePost,Long>