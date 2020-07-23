package com.malygos.gnemesuser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
@EnableWebSecurity
@EnableDiscoveryClient
class GnemesUserApplication

fun main(args: Array<String>) {
	runApplication<GnemesUserApplication>(*args)
}
