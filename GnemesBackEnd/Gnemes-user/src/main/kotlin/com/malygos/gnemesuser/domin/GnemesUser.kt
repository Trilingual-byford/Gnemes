package com.malygos.gnemesuser.domin

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity
data class GnemesUser(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var userId:Long,
        var avatar:String,
        var userName:String,
        @Column(unique = true)
        var email:String,
        var userPwd:String,
        var sex:Byte,
        var age:String,
        @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
        var registryDate:Date,
        @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
        var lastLoginTime:Date,
        @ElementCollection(fetch = FetchType.LAZY)
        var likedCollection:List<String>?,
        @ElementCollection(fetch = FetchType.LAZY)
        var savedCollection:List<String>?,
        @ElementCollection(fetch = FetchType.LAZY)
        var loginDevices:List<String>,
        @ElementCollection(fetch = FetchType.LAZY)
        var readGnemesHistory:List<String>
)