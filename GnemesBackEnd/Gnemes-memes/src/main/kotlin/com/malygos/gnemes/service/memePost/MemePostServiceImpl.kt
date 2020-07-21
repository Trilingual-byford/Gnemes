package com.malygos.gnemes.service.memePost

import com.malygos.gnemes.domain.MemePost
import com.malygos.gnemes.dto.MemePostCreationDto
import com.malygos.gnemes.exception.exception.MemePostUpdateNotFoundException
import com.malygos.gnemes.repository.MemeRepository
import com.malygos.gnemes.service.storage.s3.AmazonS3ClientService
import com.malygos.gnemes.utils.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class MemePostServiceImpl @Autowired constructor() : MemePostService {
    @Autowired
    lateinit var storage: AmazonS3ClientService

    @Autowired
    lateinit var memePostRepository: MemeRepository
    override fun addMemePost(memePost: MemePostCreationDto, file: MultipartFile): Mono<MemePost> {
        val fileS3Dir = storage.uploadFileToS3Bucket(file, true)
        val tmpEntityObj = MemePost(null, Date(), memePost.difficulty, fileS3Dir, 0, 0, memePost.tag, memePost.oLSentences, memePost.sLSentences, memePost.phrase)
        return memePostRepository.save(tmpEntityObj)
    }

    override fun deleteMemePost(id: String) {
        memePostRepository.findById(id).map {
            val fileName = StringUtils.getFileNameFromUrl(it.dir)
            storage.deleteFileFromS3Bucket(fileName)
        }.switchIfEmpty(Mono.error(MemePostUpdateNotFoundException("Could not find original delete fail")))
                .doOnSuccess {
                    memePostRepository.deleteById(id).doOnSuccess {
                        print("suss")
                    }.subscribe()
                }.doOnError {
                    throw it
                }
                .subscribe()
    }

    override fun updateMemePost(memePost: MemePost): Mono<MemePost> {
        return memePostRepository.findById(memePost.id!!)
                .switchIfEmpty(Mono.error(MemePostUpdateNotFoundException("Could not find original post,Failed")))
                .map {
                    memePostRepository.save(it).subscribe()
                    return@map it
                }
    }

    override fun findMemePostById(id: String): Mono<MemePost> {
        return memePostRepository.findById(id)
    }

    @Transactional
    override fun findMemePostByPostId(id: String): Mono<MemePost> {
        return memePostRepository.findById(id)
    }

    override fun findAllMemePost(): Flux<MemePost> {
        return memePostRepository.findAll()
    }
}