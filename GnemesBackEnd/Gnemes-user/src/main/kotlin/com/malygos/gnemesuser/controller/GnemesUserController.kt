package com.malygos.gnemesuser.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/gnemes/user")
class GnemesUserController {
    @ResponseBody
    @GetMapping(value = ["/"])
    fun registerGnemes():String{
        return "hahahahahha"
    }

}