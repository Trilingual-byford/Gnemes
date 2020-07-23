package com.malygos.gnemesuser.domin

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class ReadingHistory(
        var id:Long,
        var userEmail:String,
        @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
        var startReadingTime:Date,
        var postId:String
)