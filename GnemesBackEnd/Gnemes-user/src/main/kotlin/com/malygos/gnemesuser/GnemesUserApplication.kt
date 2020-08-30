package com.malygos.gnemesuser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
@EnableDiscoveryClient(autoRegister = true)
class GnemesUserApplication

fun main(args: Array<String>) {
    runApplication<GnemesUserApplication>(*args)
}
