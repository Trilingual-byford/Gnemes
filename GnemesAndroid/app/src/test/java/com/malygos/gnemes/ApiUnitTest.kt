package com.malygos.gnemes

import com.malygos.gnemes.data.network.GnemesApiService
import org.junit.Test

 fun ApiUnitTest.log(log:String){
    println("hahaha$log")
}

class ApiUnitTest {
    @Test
    fun getPostUnitTest(){
//        val s = name ?: "lol"
//        val b = name?.length ?: 0 < 4
        // Lamda argument should be moved out of parenthess
        repeat(10) {
            log(it.toString())
        }
    }

}