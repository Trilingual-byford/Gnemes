package com.malygos.gnemes.dto

data class ResultObj (
        var succeeded:Boolean?,
        var msg:String?
){
    constructor() :this(null,null)
}