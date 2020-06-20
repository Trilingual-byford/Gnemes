package com.malygos.gnemes.service.memePost

import com.malygos.gnemes.domain.MemePost
import java.util.*

interface MemePostService {
    fun addMemePost(memePost: MemePost): MemePost
    fun deleteMemePost(id: Long)
    fun updateMemePost(memePost: MemePost): MemePost
    fun findMemePostById(id: Long): Optional<MemePost>
    fun findAllMemePost():List<MemePost>
}