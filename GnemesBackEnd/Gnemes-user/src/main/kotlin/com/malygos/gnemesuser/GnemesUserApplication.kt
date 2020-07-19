package com.malygos.gnemesuser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class GnemesUserApplication

fun main(args: Array<String>) {
	runApplication<GnemesUserApplication>(*args)
}
