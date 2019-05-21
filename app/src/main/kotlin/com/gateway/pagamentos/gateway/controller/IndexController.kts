package com.gateway.pagamentos.gateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class IndexController() {

    @GetMapping("")
    fun index(): String {
        return "Api Kotlin"
    }
}