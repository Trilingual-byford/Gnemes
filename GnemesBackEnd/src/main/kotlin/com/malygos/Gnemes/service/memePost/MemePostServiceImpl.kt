package com.malygos.Gnemes.service.memePost

import com.malygos.Gnemes.domain.MemePost
import com.malygos.Gnemes.exception.exception.MemePostUpdateNotFoundException
import com.malygos.Gnemes.repository.MemeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemePostServiceImpl @Autowired constructor(val memePostRepository: MemeRepository):MemePostService{

    override fun addMemePost(memePost: MemePost): MemePost {
        return memePostRepository.saveAndFlush(memePost)
    }

    override fun deleteMemePost(id: Long) {
        return memePostRepository.deleteById(id)
    }

    override fun updateMemePost(memePost: MemePost): MemePost {
        if(memePostRepository.findById(memePost.id!!).isEmpty){
            return memePostRepository.saveAndFlush(memePost)
        }else{
            throw MemePostUpdateNotFoundException("Could not find original post,Failed")
        }
    }

    override fun findMemePostById(id: Long): Optional<MemePost> {
        return memePostRepository.findById(id)
    }
    override fun findAllMemePost():List<MemePost>{
        return memePostRepository.findAll()
    }
}