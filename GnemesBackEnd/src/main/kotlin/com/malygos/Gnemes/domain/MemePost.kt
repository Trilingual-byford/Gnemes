package com.malygos.Gnemes.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.malygos.Gnemes.annotation.Domain
import java.util.*
import javax.persistence.*
@Entity
@Domain
data class MemePost(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @JsonFormat(pattern = "yyyy-MM-dd")
        var createdTime: Date,
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
        var phrase: List<String>?,
        @OneToMany
        var comment: List<MemeComment>?
)
