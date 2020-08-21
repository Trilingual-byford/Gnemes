package com.malygos.gnemes.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonRawValue
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document(collection = "GnemesPost")
data class MemePost(
        @Id
        var id: String?,
        @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
        var createdTime: Date,
        /**
         * Meme difficulty level
         * obvious：1
         * mediocre：2
         * tough：3
         * pro：4
         * monster：5
         * god : 6
         */
        var difficulty: Byte,
        var dir: String,
        var likes: Long,
        var viewer: Long,
        var picHash: String,
        var tag: List<String>?,
        //Original Language Sentences
        @JsonRawValue
        var oLSentences: List<String>?,
        //Second Language Sentences
        @JsonRawValue
        var sLSentences: List<String>?,
        var phrase: List<String>?
)
