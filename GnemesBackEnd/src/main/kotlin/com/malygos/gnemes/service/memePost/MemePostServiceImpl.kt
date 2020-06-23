package com.malygos.gnemes.service.memePost

import com.malygos.gnemes.domain.MemePost
import com.malygos.gnemes.exception.exception.MemePostUpdateNotFoundException
import com.malygos.gnemes.repository.MemeRepository
import com.malygos.gnemes.utils.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class MemePostServiceImpl @Autowired constructor(val memePostRepository: MemeRepository):MemePostService{

    override fun addMemePost(memePost: MemePost): MemePost {
        memePost.postId=StringUtils.get25DigitalsRandomAlphanumeric()
        return memePostRepository.saveAndFlush(memePost)
    }

    override fun deleteMemePost(id: Long) {
        return memePostRepository.deleteById(id)
    }

    override fun updateMemePost(memePost: MemePost): MemePost {
        if(memePostRepository.findById(memePost.id!!).isEmpty){
            return memePostRepository.saveAndFlush(memePost)
        }
        throw MemePostUpdateNotFoundException("Could not find original post,Failed")
    }

    override fun findMemePostById(id: Long): Optional<MemePost> {
        return memePostRepository.findById(id)
    }

    @Transactional
    override fun findMemePostByPostId(postId: String): Optional<MemePost> {
        return memePostRepository.findMemePostByPostId(postId)
    }

    override fun findAllMemePost():List<MemePost>{
        return memePostRepository.findAll()
    }
}