package com.malygos.gnemes.data.entity

data class UserAuthInfo (
    val email:String,
    val avatarURL:String,
    val userName:String,
    val authToken:String,
    val tokenExpiredDate:String
)