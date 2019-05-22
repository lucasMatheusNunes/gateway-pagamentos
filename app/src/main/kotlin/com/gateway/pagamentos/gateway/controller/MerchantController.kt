package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.dataRandom.RandomMerchant
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

    private var randomMerchant : RandomMerchant = RandomMerchant()

    @ApiOperation(
            value = "Get list of Merchants",
            response = Merchant::class
    )
    @GetMapping(produces = arrayOf("application/json"))
    fun getAll(@RequestParam("qtde", defaultValue = "0") qtde: Long) : ArrayList<Merchant> {
        return randomMerchant.getAll(qtde)
    }

    @ApiOperation(
            value = "Get Merchant by id",
            response = Merchant::class
    )
    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getOne(@PathVariable("id") id: Int) : Merchant{
        return randomMerchant.getById(id)
    }

    @ApiOperation(
            value = "Add a new merchant",
            response = SuccessCallback::class
    )
    @PostMapping(produces = arrayOf("application/json"))
    fun add(@Valid @RequestBody merchant: Merchant) : ResponseEntity<SuccessCallback>{
        return ResponseEntity(SuccessCallback("client_created","Merchant created with successful",randomMerchant.getRandomInt(), randomMerchant.getRandomToken()), HttpStatus.CREATED)
    }
}