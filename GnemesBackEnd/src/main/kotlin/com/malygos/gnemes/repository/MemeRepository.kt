package com.malygos.gnemes.repository

import com.malygos.gnemes.domain.MemePost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface MemeRepository: JpaRepository<MemePost,Long>{

    fun findMemePostByPostId(title: String): Optional<MemePost>

}