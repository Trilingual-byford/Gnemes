package com.malygos.Gnemes.service.storage.s3

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AmazonS3ClientServiceImpl @Autowired constructor(aWSCredentialsProvider: AWSCredentialsProvider): AmazonS3ClientService {
    @Value("\${amazonProperties.endpointUrl}")
    private val endpointUrl: String? = null

    @Value("\${amazonProperties.bucketName}")
    private val bucketName: String? = null

    @Value("\${amazonProperties.region}")
    private val awsRegion: String? = null

//    @Qualifier("awsCredentialsProvider")
//    private lateinit var aWSCredentialsProvider: AWSCredentialsProvider

    private lateinit var amazonS3:AmazonS3

    init {
        AmazonS3ClientBuilder.standard()
                .withCredentials(aWSCredentialsProvider)
                .withRegion(awsRegion)
                .build()

    }

    override fun uploadFileToS3Bucket(multipartFile: MultipartFile?, enablePublicReadAccess: Boolean) {
        TODO("Not yet implemented")
    }

    override fun deleteFileFromS3Bucket(fileName: String?) {
        TODO("Not yet implemented")
    }
}