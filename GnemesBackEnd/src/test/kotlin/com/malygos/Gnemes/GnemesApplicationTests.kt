package com.malygos.Gnemes

import com.malygos.Gnemes.service.storage.s3.AmazonS3ClientService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

@SpringBootTest
class GnemesApplicationTests {
	@Autowired
   lateinit var  amazonS3ClientService:AmazonS3ClientService
	@Test
	fun contextLoads() {
	}
	@Test
	fun S3UploadTest(){
		val imgPath = Paths.get("./src/main/resources/static/animal-meme-test.jpeg")
		val fileBytes = Files.readAllBytes(imgPath)
		val mockMultipartFile = MockMultipartFile("animal-meme-test.jpeg","animal-meme-test.jpeg","image/jpeg", fileBytes)
		mockMultipartFile.originalFilename
		val result = amazonS3ClientService.uploadFileToS3Bucket(mockMultipartFile, true)
	}

}
