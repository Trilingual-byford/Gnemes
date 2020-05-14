package com.malygos.gnemes.data.entity

data class MemePost(
    var comment: List<MemeComment>?,
    var createdTime: String?,
    var dir: String?,
    var id: Int,
    var likes: Int?,
    var olsentences: List<String>?,
    var phrase: List<String>?,
    var slsentences: List<String>?,
    var tag: List<String>?,
    var viewer: Int?
)