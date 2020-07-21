package com.malygos.gnemes.service.memePost

import com.malygos.gnemes.domain.MemePost
import org.bson.types.ObjectId
import java.util.*

interface MemePostService {
    fun addMemePost(memePost: MemePost): MemePost
    fun deleteMemePost(id: String)
    fun updateMemePost(memePost: MemePost): MemePost
    fun findMemePostById(id: String): Optional<MemePost>
    fun findMemePostByPostId(id: String): Optional<MemePost>
    fun findAllMemePost():List<MemePost>
}