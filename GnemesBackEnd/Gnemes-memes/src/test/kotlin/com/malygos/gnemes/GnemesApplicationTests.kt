package com.malygos.gnemes

import com.malygos.gnemes.domain.MemePost
import com.malygos.gnemes.job.ChangeDataBaseTable
import com.malygos.gnemes.service.memePost.MemePostService
import com.malygos.gnemes.service.storage.s3.AmazonS3ClientService
import com.malygos.gnemes.utils.StringUtils
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import java.nio.file.Files
import java.nio.file.Paths

@SpringBootTest
class GnemesApplicationTests {
    @Autowired
    lateinit var amazonS3ClientService: AmazonS3ClientService

    @Autowired
    lateinit var postService: MemePostService

    @Test
    fun contextLoads() {
    }

    @Test
    fun s3UploadTest() {
        val imgPath = Paths.get("./src/main/resources/static/animal-meme-test.jpeg")
        val fileBytes = Files.readAllBytes(imgPath)
        val mockMultipartFile = MockMultipartFile("animal-meme-test.jpeg", "animal-meme-test.jpeg", "image/jpeg", fileBytes)
        mockMultipartFile.originalFilename
        amazonS3ClientService.uploadFileToS3Bucket(mockMultipartFile, true)
    }

    @Test
    fun s3DeleteTest() {
        amazonS3ClientService.deleteFileFromS3Bucket("newName.jpg")
    }

    @Test
    fun stringUtilTest() {
        val url = "https://genemes-pic.s3.ap-northeast-1.amazonaws.com/ca.jpeg"
        val fileNameFromUrl = StringUtils.getFileNameFromUrl(url)
        assert(fileNameFromUrl.equals("ca.jpeg"))
    }

    @Test
    fun serviceGetTest() {
        val findAllMemePost = postService.findAllMemePost()
    }

    @Test
    fun Random16DigitalUUIDTEst() {
        val randomAlphanumeric = RandomStringUtils.randomAlphanumeric(20)
        val randomAlphanumeric2 = RandomStringUtils.randomAlphanumeric(25)
        println(randomAlphanumeric)
        println(randomAlphanumeric2)
    }

    @Test
    fun addPostId() {
        ChangeDataBaseTable.insertPostId(postService)
    }

    @Test
    fun searchByPostIdTest() {
        postService.deleteMemePost("5f171cae765b1da3d5cf56")
    }


}
