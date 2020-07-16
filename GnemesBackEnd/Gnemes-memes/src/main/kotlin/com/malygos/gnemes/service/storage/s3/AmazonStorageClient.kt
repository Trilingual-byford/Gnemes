package com.malygos.gnemes.service.storage.s3

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AmazonStorageClient {
    @Value("\${amazonProperties.accessKey}")
    private val accessKey: String? = null

    @Value("\${amazonProperties.secretKey}")
    private val secretKey: String? = null


    @Bean(name = ["awsCredentialsProvider"])
    fun getAWSCredentials(): AWSCredentialsProvider? {
        val awsCredentials = BasicAWSCredentials(this.accessKey, this.secretKey)
        return AWSStaticCredentialsProvider(awsCredentials)
    }
}