package com.malygos.gnemes.dto

data class MemePostCreationDto(
        var tag: List<String>?,
        var difficulty:Int,
        var oLSentences: List<String>?,
        var sLSentences: List<String>?,
        var phrase: List<String>?
        )