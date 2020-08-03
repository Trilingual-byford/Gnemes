package com.byford.daas.service.storage

import exception.StorageException
import exception.StorageFileNotFoundException
import java.io.IOException
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.stream.Stream

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile

@Service
class FileSystemStorageService : StorageService {
    lateinit var rootLocation: Path

    @Autowired
    fun fileSystemStorageService(properties: StorageProperties) {
        this.rootLocation = Paths.get(properties.location)
    }

    override fun init() {
        try {
            Files.createDirectories(rootLocation)
        } catch (e: IOException) {
            throw StorageException("Could not initialize storage", e)
        }
    }

    override fun store(file: MultipartFile) {
        val filename: String = StringUtils.cleanPath(file.originalFilename!!);
        try {
            if (file.isEmpty) {
                throw StorageException("Failed to store empty$filename");
            }
            if (filename.contains("..")) {
                throw StorageException("Cannot store file with relative path outside current directory$filename");
            }
            file.inputStream.use { inputStream ->
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING)
            }
        } catch (e: IOException) {
            throw StorageException("Failed to store empty$filename", e);
        }
    }

    override fun loadAll(): Stream<Path> {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter { path -> !path.equals(this.rootLocation) }
                    .map(this.rootLocation::relativize)
        } catch (e: IOException) {
            throw StorageException("Failed to read stored files", e)
        }
    }

    override fun load(filename: String): Path {
        return rootLocation.resolve(filename)
    }

    override fun loadAsResource(filename: String): Resource {
        try {
            val file = load(filename)
            val resource = UrlResource(file.toUri())
            if (resource.exists() || resource.isReadable) {
                return resource
            } else {
                throw StorageFileNotFoundException("Could not read file:$filename")
            }
        } catch (e: MalformedURLException) {
            throw StorageFileNotFoundException("Could not read file:$filename", e)
        }

    }

    override fun deleteAll() {
        //To change body of created functions use File | Settings | File Templates.
    }
}