package com.malygos.gnemes.data.entity

import java.util.*

data class MemeComment (
    var id: Long,
    var userName: String? =null,
    var comment:String,
    var postDate: Date
)