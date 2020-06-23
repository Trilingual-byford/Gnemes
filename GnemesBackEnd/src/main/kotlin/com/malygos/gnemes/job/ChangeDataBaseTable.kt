package com.malygos.gnemes.job

import com.malygos.gnemes.service.memePost.MemePostService
import com.malygos.gnemes.utils.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
object ChangeDataBaseTable {

    fun insertPostId(memePostService: MemePostService){
        val allMemePost = memePostService.findAllMemePost()

        allMemePost.forEach {
            it.postId=StringUtils.get25DigitalsRandomAlphanumeric()
            it.difficulty=1
            memePostService.updateMemePost(it)
        }
    }
}