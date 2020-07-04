package com.malygos.gnemes.data.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.malygos.gnemes.data.entity.MemeComment
import java.util.*
import kotlin.collections.ArrayList


class MemeDataConverter {
    @TypeConverter
    fun strListToStr(strList:List<String>?):String{
        var string = ""
        if (strList != null) {
            for (s in strList) string += "$s---"
        }
        return string
    }
    @TypeConverter
    fun strToStrList(str:String): List<String>? {
        if (str=="") {
            return null
        }
        return str.split("---").dropLast(1)
    }
    @TypeConverter
    fun fromMemeCommentList(value: List<MemeComment>): String {
        val gson = Gson()
        val type = object : TypeToken<List<MemeComment>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toMemeCommentList(value: String): List<MemeComment> {
        val gson = Gson()
        val type = object : TypeToken<List<MemeComment>>() {}.type
        return gson.fromJson(value, type)
    }

}