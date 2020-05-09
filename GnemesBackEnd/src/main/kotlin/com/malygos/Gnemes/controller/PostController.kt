package com.malygos.Gnemes.controller

import com.malygos.Gnemes.domain.MemePost
import com.malygos.Gnemes.dto.MemePostCreationDto
import com.malygos.Gnemes.service.memePost.MemePostService
import com.malygos.Gnemes.service.storage.s3.AmazonS3ClientService
import org.jetbrains.annotations.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/api/v1/gnemes/post")
class PostController @Autowired constructor(val storage:AmazonS3ClientService,val memePostServiceImpl: MemePostService){
    var logger: Logger = LoggerFactory.getLogger(PostController::class.java)

//    @ResponseBody
//    @GetMapping(value = ["/{id}"])
//    fun findDogById(@PathVariable("id") id: Long, model: Model): ResponseEntity<Inu> {
//        val inuInstance = inuServiceImpl.findInuById(id)
//        logger.info("Find dog By id", inuInstance)
//        return ResponseEntity(inuInstance, HttpStatus.OK)
//    }
//
//    @ResponseBody
//    @GetMapping(path = ["/all"])
//    fun findAllDog(model: Model): ResponseEntity<List<Inu>> {
//        return ResponseEntity(inuServiceImpl.findAllInu(), HttpStatus.OK)
//
//    }

    //Add more Post
//    @JsonFormat(pattern = "yyyy-MM-dd")

    @ResponseBody
    @PostMapping(value = ["/"],consumes = ["multipart/form-data"])
    fun addMemePost(@RequestPart("meta")@Valid memePost: MemePostCreationDto, @RequestPart("file")@Valid @NotNull @NotBlank file: MultipartFile): ResponseEntity<MemePost> {
        val fileS3Dir = storage.uploadFileToS3Bucket(file, true)
        val tmpEntityObj=MemePost(null,Date(),fileS3Dir,0,0,memePost.tag,memePost.oLSentences,memePost.sLSentences,memePost.phrase,null)
        memePostServiceImpl.addMemePost(tmpEntityObj)
        return ResponseEntity(tmpEntityObj, HttpStatus.OK)
    }

//    @ResponseBody
//    @DeleteMapping(value = ["/{id}"])
//    fun deleteInu(@PathVariable id: Long): String {
//        inuServiceImpl.deleteInu(id)
//        return "Id:$id Inu is gone by now"
//    }
//
//    @ResponseBody
//    @PutMapping(value = ["/{id}"])
//    fun updateInu(@PathVariable id: Long, @RequestBody model: Inu): Inu {
//        val updatedInu = inuServiceImpl.updateInu(model, id)
//        return updatedInu
//    }

}