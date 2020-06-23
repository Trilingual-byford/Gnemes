package com.malygos.gnemes.utils

import org.apache.commons.lang3.RandomStringUtils

object StringUtils {
    fun getFileNameFromUrl(url:String):String{
        val split = url.split("/")
        return split.last()
    }
    fun get25DigitalsRandomAlphanumeric():String{
        return  RandomStringUtils.randomAlphanumeric(25)
    }
}