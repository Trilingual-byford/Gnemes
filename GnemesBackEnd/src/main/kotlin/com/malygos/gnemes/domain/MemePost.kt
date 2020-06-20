package com.malygos.gnemes.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.malygos.gnemes.annotation.Domain
import java.util.*
import javax.persistence.*
@Entity
@Domain
data class MemePost(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var postId: Long?,
        @JsonFormat(pattern = "yyyy-MM-dd")
        var createdTime: Date,
        /**
         * Meme difficulty level
         * obvious：100
         * mediocre：200
         * tough：300
         * pro：400
         * monster：500
         * god : 600
         */
        var difficulty:Int,
        var dir: String,
        var likes: Long,
        var viewer: Long,
        @ElementCollection
        var tag: List<String>?,
        //Original Language Sentences
        @ElementCollection
        var oLSentences: List<String>?,
        //Second Language Sentences
        @ElementCollection
        var sLSentences: List<String>?,
        @ElementCollection
        var phrase: List<String>?
)
