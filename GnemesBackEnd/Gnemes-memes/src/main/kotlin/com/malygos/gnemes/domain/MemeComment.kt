package com.malygos.gnemes.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class MemeComment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var commentId: Long,
        var postId:Long,
        var userId:Long,
        var userName: String? =null,
        var comment:String,
        var postDate:Date
)

