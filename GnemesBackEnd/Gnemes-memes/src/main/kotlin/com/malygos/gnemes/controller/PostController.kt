package com.malygos.gnemes.controller

import com.malygos.gnemes.domain.MemePost
import com.malygos.gnemes.dto.MemePostCreationDto
import com.malygos.gnemes.service.memePost.MemePostService
import org.jetbrains.annotations.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@CrossOrigin()
@RequestMapping("/api/v1/gnemes/post")
class PostController @Autowired constructor(val memePostService: MemePostService) {
    var logger: Logger = LoggerFactory.getLogger(PostController::class.java)

    @ResponseBody
    @PostMapping(value = ["/"], consumes = ["multipart/form-data"])
    fun addMemePost(@RequestPart("meta") @Valid memePost: MemePostCreationDto, @RequestPart("file") @Valid @NotNull @NotBlank file: FilePart): ResponseEntity<Mono<MemePost>> {
        val addMemePost = memePostService.addMemePost(memePost, file)
        return ResponseEntity(addMemePost, HttpStatus.OK)
//        return "ResponseEntity(null, HttpStatus.OK)"
    }

    @ResponseBody
    @PutMapping(value = ["/"])
    fun updateMemePost(@RequestPart("meta") @Valid memePost: MemePost): ResponseEntity<Mono<MemePost>> {
        val addMemePost = memePostService.updateMemePost(memePost)
        return ResponseEntity(addMemePost, HttpStatus.OK)
    }

    @ResponseBody
    @DeleteMapping(value = ["/{id}"])
    fun deleteMemePost(@PathVariable id: String): Mono<String> {
        return memePostService.deleteMemePost(id)
    }

    @ResponseBody
    @GetMapping(value = ["/"])
    fun getMemePost(): Flux<MemePost> {
        return memePostService.findAllMemePost()
    }
    @ResponseBody
    @GetMapping(value = ["/refactory"])
    fun refactoryMemePost(): Flux<MemePost> {

        return memePostService.findAllMemePost()
    }

}