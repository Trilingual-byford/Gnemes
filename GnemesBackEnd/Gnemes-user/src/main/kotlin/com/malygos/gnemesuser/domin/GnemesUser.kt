package com.malygos.gnemesuser.domin

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Document(collection = "GnemesUser")
data class GnemesUser(
        @Id
        var userId:String,
        @DBRef
        var role: GnemesRole,
        var avatar:String,
        @NotBlank
        @Size(max=20)
        var userName:String,
        @NotBlank
        @Size(max=20)
        @Email
        var email:String,
        var userPwd:String,
        var sex:Byte,
        var age:String,
        var registryDate:Date,
        var lastLoginTime:Date,
        var likedCollection:List<String>?,
        var savedCollection:List<String>?,
        var loginDevices:List<String>,
        var readGnemesHistory:List<ReadingHistory>
)