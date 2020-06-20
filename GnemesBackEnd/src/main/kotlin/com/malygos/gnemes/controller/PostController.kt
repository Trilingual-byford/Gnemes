package com.malygos.gnemes.controller

import com.malygos.gnemes.domain.MemePost
import com.malygos.gnemes.dto.MemePostCreationDto
import com.malygos.gnemes.service.memePost.MemePostService
import com.malygos.gnemes.service.storage.s3.AmazonS3ClientService
import com.malygos.gnemes.utils.StringUtils
import org.jetbrains.annotations.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*
import java.util.function.Consumer
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/api/v1/gnemes/post")
class PostController @Autowired constructor(val storage: AmazonS3ClientService, val memePostService: MemePostService) {
    var logger: Logger = LoggerFactory.getLogger(PostController::class.java)

    @ResponseBody
    @PostMapping(value = ["/"], consumes = ["multipart/form-data"])
    fun addMemePost(@RequestPart("meta") @Valid memePost: MemePostCreationDto, @RequestPart("file") @Valid @NotNull @NotBlank file: MultipartFile): ResponseEntity<MemePost> {
        val fileS3Dir = storage.uploadFileToS3Bucket(file, true)
        val tmpEntityObj = MemePost(null, Date(), memePost.difficulty, fileS3Dir, 0, 0, memePost.tag, memePost.oLSentences, memePost.sLSentences, memePost.phrase)
        memePostService.addMemePost(tmpEntityObj)
        return ResponseEntity(tmpEntityObj, HttpStatus.OK)
    }

    @ResponseBody
    @DeleteMapping(value = ["/"])
    fun deleteMemePost(@PathVariable id: Long): String {
        memePostService.findMemePostById(id).ifPresent(Consumer {
            val fileName = StringUtils.getFileNameFromUrl(it.dir)
            storage.deleteFileFromS3Bucket(fileName)
        })
        memePostService.deleteMemePost(id)
        return "Id:$id Inu is gone by now"
    }

    @ResponseBody
    @GetMapping(value = ["/"])
    fun getMemePost(): List<MemePost> {
        return memePostService.findAllMemePost()
    }

}