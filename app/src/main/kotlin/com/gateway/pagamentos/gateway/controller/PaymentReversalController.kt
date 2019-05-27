package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.dataRandom.GenericRandom
import com.gateway.pagamentos.gateway.dataRandom.PaymentReversalRandom
import com.gateway.pagamentos.gateway.entity.PaymentReversal
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.validation.BindingResult
import javax.validation.Valid

@RestController
@RequestMapping("/payment-reversal")
@Api(description = "REST api related to Payment reversal")
class PaymentReversalController {

    private var paymentReversalRandom : PaymentReversalRandom = PaymentReversalRandom()
    private var genericRandom : GenericRandom = GenericRandom()

    @ApiOperation(
            value = "Get list of Payments reversal",
            response = PaymentReversal::class
    )
    @GetMapping(produces = arrayOf("application/json"))
    fun getAll( @RequestHeader("token") token : String) : ArrayList<PaymentReversal> {
        return paymentReversalRandom.getAll()
    }

    @ApiOperation(
            value = "Get Payment reversal by id",
            response = PaymentReversal::class
    )
    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getOne(@PathVariable("id") id : Int, @RequestHeader("token") token : String) : PaymentReversal {
        return paymentReversalRandom.getById(id)
    }

    @ApiOperation(
            value = "Reverse payment",
            response = SuccessCallback::class
    )
    @PostMapping(produces = arrayOf("application/json"))
    fun add(@Valid @RequestBody paymentReversal : PaymentReversal, binding : BindingResult, @RequestHeader("token") token : String) : ResponseEntity<Any> {
        return if(binding.hasErrors()) {
            ResponseEntity(binding.fieldError, HttpStatus.BAD_REQUEST)
        }else {
            ResponseEntity(SuccessCallback("canceled_payment", "Payment canceled with success", genericRandom.getRandomInt()), HttpStatus.OK)
        }
    }

}