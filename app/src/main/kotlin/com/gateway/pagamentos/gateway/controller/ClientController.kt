package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.entity.Client
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client")
@Api(description = "REST Api related to Client entity")
class ClientController {


    @ApiOperation(
            value = "Get list of Clients",
            response = Client::class
    )

    @RequestMapping(method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    fun getAll() : Client {

        val joao = Client(0, "Lucas Matheus Nunes", "lucas.nunes@zup.com.br", emptyList(), emptyList(), emptyList())

        return joao
    }
}