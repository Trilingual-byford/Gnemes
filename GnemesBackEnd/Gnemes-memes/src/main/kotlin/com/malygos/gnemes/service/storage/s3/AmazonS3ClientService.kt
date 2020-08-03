package com.malygos.gnemes.service.storage.s3

import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.multipart.MultipartFile


interface AmazonS3ClientService {
    fun uploadFileToS3Bucket(multipartFile: MultipartFile, enablePublicReadAccess: Boolean): String
    fun uploadFileToS3Bucket(multipartFile: FilePart, enablePublicReadAccess: Boolean): String
    fun deleteFileFromS3Bucket(fileName: String?)
}