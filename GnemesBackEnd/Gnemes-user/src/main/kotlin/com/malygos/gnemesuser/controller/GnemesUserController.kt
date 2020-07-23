package com.malygos.gnemesuser.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/gnemes/auth")
class GnemesUserController {
    @ResponseBody
    @PostMapping(value = ["/signup"])
    fun registerGnemes():String{
        return "hahahahahha"
    }
    fun signInGenemes():String{
        return "gogogo"
    }

}