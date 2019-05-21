package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.entity.Payment
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payment")
@Api(description = "REST Api related to Payment entity")
class PaymentController {

    @ApiOperation(
            value = "Get list of Payment",
            response = Payment::class
    )

    @RequestMapping(method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    fun getAll() : Payment {

        val readWriteMap = hashMapOf("description" to "coffee");

        return Payment(0, "credit_card", 1.99, HashMap(readWriteMap),"jhl254359ykjhfs876543kjwt8734")
    }

    @PostMapping
    fun add(){

    }
}