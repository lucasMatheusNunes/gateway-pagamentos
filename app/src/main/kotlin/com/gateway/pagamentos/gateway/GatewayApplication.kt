package com.gateway.pagamentos.gateway

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class GatewayPagamentosApplication

fun main(args: Array<String>) {
	runApplication<GatewayPagamentosApplication>(*args)
}
