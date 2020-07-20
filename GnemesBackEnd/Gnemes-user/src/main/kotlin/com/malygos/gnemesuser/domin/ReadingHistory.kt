package com.malygos.gnemesuser.domin

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ReadingHistory(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long,
        var userEmail:String,
        @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
        var startReadingTime:Date,
        var postId:String
)