package com.malygose.gnemesgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient(autoRegister = true)
class GnemesGatewayApplication

fun main(args: Array<String>) {
	runApplication<GnemesGatewayApplication>(*args)
}
