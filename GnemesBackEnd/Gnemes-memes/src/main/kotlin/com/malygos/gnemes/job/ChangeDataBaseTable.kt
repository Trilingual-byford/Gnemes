package com.malygos.gnemes.job

import com.malygos.gnemes.service.memePost.MemePostService
import com.malygos.gnemes.utils.StringUtils
import org.springframework.stereotype.Component
import java.net.URL
import javax.imageio.ImageIO

@Component
object ChangeDataBaseTable {

    fun insertPostId(memePostService: MemePostService) {
        val allMemePost = memePostService.findAllMemePost()
        allMemePost.map {
            print("Map.dddddddddd"+it)
        }.doOnError{
            println(it) }.subscribe()
        allMemePost.subscribe {
            println("ddddddddddd"+it.dir)}
    }
    fun addPHashToPic(){
//        memePostRepository.findAll().map {
//            val dir = it.dir
//            val url = URL(dir)
//            val read = ImageIO.read(url)
//            val hash = hasher.hash(read)
//            it.picHash=hash.toString()
//            logger.info("URL:",url,"hash",hash.toString())
//            return@map it
//        }.map {
//            updateMemePost(it).block()
//        }.subscribe()
    }
}