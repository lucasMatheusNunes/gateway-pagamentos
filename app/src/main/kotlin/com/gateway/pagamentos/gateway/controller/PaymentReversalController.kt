package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.entity.PaymentReversal
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/payment-reversal")
@Api(description = "REST api related to Payment reversal")
class PaymentReversalController {

    @ApiOperation(
            value = "Reverse payment"
    )
    @PostMapping(produces = arrayOf("application/json"))
    fun add(@RequestBody merchant : PaymentReversal) : ResponseEntity<SuccessCallback> {

        return ResponseEntity(SuccessCallback("canceled_payment", "Payment canceled with success", 6), HttpStatus.OK)
    }

}