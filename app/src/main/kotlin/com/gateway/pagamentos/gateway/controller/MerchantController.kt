package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.dataRandom.GenericRandom
import com.gateway.pagamentos.gateway.dataRandom.MerchantRandom
import com.gateway.pagamentos.gateway.entity.Merchant
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/merchant")
@Api(description = "REST Api related to Merchant entity")
class MerchantController {

    private var merchantRandom : MerchantRandom = MerchantRandom()
    private var genericRandom : GenericRandom = GenericRandom()

    @ApiOperation(
            value = "Get list of Merchants",
            response = Merchant::class
    )
    @GetMapping(produces = arrayOf("application/json"))
    fun getAll(@RequestParam("qtde", defaultValue = "0") qtde: Long) : ArrayList<Merchant> {
        return merchantRandom.getAll(qtde)
    }

    @ApiOperation(
            value = "Get Merchant by id",
            response = Merchant::class
    )
    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getOne(@PathVariable("id") id: Int) : Merchant{
        return merchantRandom.getById(id)
    }

    @ApiOperation(
            value = "Add a new merchant",
            response = SuccessCallback::class
    )
    @PostMapping(produces = arrayOf("application/json"))
    fun add(@Valid @RequestBody merchant: Merchant) : ResponseEntity<SuccessCallback>{
        return ResponseEntity(SuccessCallback("client_created","Merchant created with successful",genericRandom.getRandomInt(), genericRandom.getRandomToken()), HttpStatus.CREATED)
    }
}