package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.dataRandom.RandomClient
import com.gateway.pagamentos.gateway.entity.Client
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
@Api(description = "REST Api related to Client entity")
class ClientController {


    @ApiOperation(
            value = "Get list of Clients",
            response = Client::class
    )

    @GetMapping(produces = arrayOf("application/json"))
    fun getAll(@RequestParam("qtde", defaultValue = "0") qtde: Long): ArrayList<Client> {

        var randomClient = RandomClient()

        return randomClient.getAll(qtde)
    }

    @ApiOperation(
            value = "Add a new client",
            response = SuccessCallback::class
    )

    @PostMapping(produces = arrayOf("application/json"))
    fun add(@RequestBody client: Client):  ResponseEntity<SuccessCallback>{

        return ResponseEntity(SuccessCallback("client_created","Client created with successful",10), HttpStatus.CREATED)
    }
}