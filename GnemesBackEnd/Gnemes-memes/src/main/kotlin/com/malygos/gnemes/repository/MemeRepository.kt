package com.malygos.gnemes.repository

import com.malygos.gnemes.domain.MemePost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface MemeRepository: MongoRepository<MemePost,Long>{

    fun findMemePostByPostId(title: String): Optional<MemePost>

}