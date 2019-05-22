package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.entity.CreditCard
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/credit_card")
@Api(description = "REST Api related to Credit Card entity")
class CreditCardController {

    @ApiOperation(
            value = "Add a new credit card",
            response = SuccessCallback::class
    )

    @PostMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun add(@Valid @RequestBody creditCard: CreditCard): ResponseEntity<SuccessCallback> {

        return ResponseEntity(SuccessCallback("credit_card_created","Credit Card created with successful",creditCard.id), HttpStatus.CREATED)
    }
}