package com.malygos.Gnemes.utils

object StringUtils {
    fun getFileNameFromUrl(url:String):String{
        val split = url.split("/")
        return split.last()
    }
}