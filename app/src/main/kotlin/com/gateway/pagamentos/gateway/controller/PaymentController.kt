package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.dataRandom.GenericRandom
import com.gateway.pagamentos.gateway.entity.Payment
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.ArrayList
import javax.validation.Valid

@RestController
@RequestMapping("/payment")
@Api(description = "REST Api related to Payment entity")
class PaymentController {

    private var genericRandom : GenericRandom = GenericRandom()

    @ApiOperation(
            value = "Add a new payment",
            response = SuccessCallback::class
    )

    @PostMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun add(@Valid @RequestBody payment: Payment): ResponseEntity<Any>{

        return ResponseEntity(SuccessCallback("payment_created","Payment created with successful",genericRandom.getRandomInt()), HttpStatus.CREATED)
    }

    @ApiOperation(
            value = "Get Payment by id",
            response = Payment::class
    )
    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getOne(@PathVariable("id") id: Int) : Payment{
        return Payment(id,
                "credit_card",
                1,
                1,
                1,
                199,
                "coffe",
                1)
    }

    @ApiOperation(
            value = "Get payment list ",
            response = Payment::class
    )
    @GetMapping("/", produces = arrayOf("application/json"))
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAll(@RequestParam(value = "page_items", defaultValue = "", required = false) page_items: Int?,
                           @RequestParam(value = "status", defaultValue = "", required = false) status: String,
                           @RequestParam(value = "initialDateCreate", defaultValue = "", required = false) initialDateCreate: String,
                           @RequestParam(value = "endDateCreate", defaultValue = "", required = false) endDateCreate: String,
                           @RequestParam(value = "initialDateUpdate", defaultValue = "", required = false) initialDateUpdate: String,
                           @RequestParam(value = "endDateUpdate", defaultValue = "", required = false) endDateUpdate: String,
                           @RequestParam(value = "installments", defaultValue = "", required = false) installments: Int?,
                           @RequestParam(value = "amount", defaultValue = "", required = false) amount: Int?,
                           @RequestParam(value = "card_holder_name", defaultValue = "", required = false) card_holder_name: String?,
                           @RequestParam(value = "card_last_digits", defaultValue = "", required = false) card_last_digits: Int?,
                           @RequestParam(value = "card_brand", defaultValue = "", required = false) card_brand: String): ResponseEntity<List<Payment>> {
        var listPayment = ArrayList<Payment>();

        var paymentOne = Payment(1,
                "credit_card",
                1,
                1,
                1,
                199,
                "coffe",
                1);
        listPayment.add(paymentOne);

        var paymentTwo = Payment(2,
                "credit_card",
                1,
                1,
                1,
                199,
                "coffe",
                1);
        listPayment.add(paymentTwo);

        return ResponseEntity.ok().body(listPayment);
    }
}