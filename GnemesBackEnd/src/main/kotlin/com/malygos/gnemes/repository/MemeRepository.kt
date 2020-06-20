package com.malygos.gnemes.repository

import com.malygos.gnemes.domain.MemePost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemeRepository: JpaRepository<MemePost,Long>