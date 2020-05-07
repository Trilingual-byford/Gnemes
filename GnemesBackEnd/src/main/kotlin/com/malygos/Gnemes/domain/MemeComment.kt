package com.malygos.Gnemes.domain

import com.malygos.Gnemes.annotation.Domain
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Domain
data class MemeComment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var userName: String? =null,
        var comment:String,
        var postDate:Date
)

