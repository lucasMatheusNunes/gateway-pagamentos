package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.entity.CreditCard
import com.gateway.pagamentos.gateway.entity.Payment
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

        return Payment(0, "credit_card", /*CreditCard(0,"JOSE SILVA","1234567890987","JOSE SILVA","10188607030", "1558448525", 187),*/ 1.99, /*HashMap(readWriteMap),*/"jhl254359ykjhfs876543kjwt8734")
    }

    @ApiOperation(
            value = "Add a new payment",
            response = SuccessCallback::class
    )

    @PostMapping(produces = arrayOf("application/json"))
    fun add(@RequestBody payment: Payment): ResponseEntity<SuccessCallback>{

        return ResponseEntity(SuccessCallback("payment_created","Payment created with successful",payment.id), HttpStatus.CREATED)
    }
}