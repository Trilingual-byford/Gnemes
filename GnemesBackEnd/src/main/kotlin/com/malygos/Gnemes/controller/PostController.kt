package com.malygos.Gnemes.controller

import com.malygos.Gnemes.domain.MemePost
import org.jetbrains.annotations.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/api/v1/gnemes/post")
class PostController {
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
    fun addMemePost(@RequestPart("meta")@Valid memePost: MemePost,@RequestPart("file")@Valid @NotNull @NotBlank file: MultipartFile): ResponseEntity<MemePost> {

        return ResponseEntity(memePost, HttpStatus.OK)
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