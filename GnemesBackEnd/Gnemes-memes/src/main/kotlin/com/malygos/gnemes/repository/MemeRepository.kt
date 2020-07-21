package com.malygos.gnemes.repository

import com.malygos.gnemes.domain.MemePost
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository


@Repository(value = "memePostRepository")
interface MemeRepository: ReactiveMongoRepository<MemePost, String> {
}