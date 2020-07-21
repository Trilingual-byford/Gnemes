package com.malygos.gnemes.service.memePost

import com.malygos.gnemes.domain.MemePost
import com.malygos.gnemes.dto.MemePostCreationDto
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MemePostService {
    fun addMemePost(memePost: MemePostCreationDto, file: MultipartFile): Mono<MemePost>
    fun deleteMemePost(id: String)
    fun updateMemePost(memePost: MemePost): Mono<MemePost>
    fun findMemePostById(id: String): Mono<MemePost>
    fun findMemePostByPostId(id: String): Mono<MemePost>
    fun findAllMemePost(): Flux<MemePost>
}