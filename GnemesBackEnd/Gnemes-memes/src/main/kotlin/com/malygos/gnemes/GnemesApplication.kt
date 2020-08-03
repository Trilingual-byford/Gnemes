package com.malygos.gnemes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableDiscoveryClient
class GnemesApplication

fun main(args: Array<String>) {
    runApplication<GnemesApplication>(*args)
}
