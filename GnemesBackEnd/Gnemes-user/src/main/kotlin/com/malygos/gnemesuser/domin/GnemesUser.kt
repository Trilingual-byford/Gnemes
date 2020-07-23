package com.malygos.gnemesuser.domin

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class GnemesUser(
        var userId:Long,
        var avatar:String,
        var userName:String,
        var email:String,
        var userPwd:String,
        var sex:Byte,
        var age:String,
        @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
        var registryDate:Date,
        @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
        var lastLoginTime:Date,
        var likedCollection:List<String>?,
        var savedCollection:List<String>?,
        var loginDevices:List<String>,
        var readGnemesHistory:List<String>
)