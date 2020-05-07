package com.malygos.Gnemes.service.storage.s3

import org.springframework.web.multipart.MultipartFile




interface AmazonS3ClientService {
    fun uploadFileToS3Bucket(multipartFile: MultipartFile?, enablePublicReadAccess: Boolean)

    fun deleteFileFromS3Bucket(fileName: String?)
}