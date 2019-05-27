package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.callback.RequiredFieldCallback
import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.dataRandom.GenericRandom
import com.gateway.pagamentos.gateway.entity.CreditCard
import com.gateway.pagamentos.gateway.exception.ApiFieldError
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.ArrayList
import javax.validation.Valid

@RestController
@RequestMapping("/credit_card")
@Api(description = "REST Api related to Credit Card entity")
class CreditCardController {

    private var genericRandom : GenericRandom = GenericRandom()

    @ApiOperation(
            value = "Get Credit Card by id",
            response = CreditCard::class
    )
    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getOne(@PathVariable("id") id: Int) : CreditCard{
        return CreditCard(id,
                1,
                "JOSE SILVA",
                "12341234",
                "JOSE SILVA",
                "1234567890",
                "21/05/2019 08:00",
                197,
                "1234")
    }

    @ApiOperation(
            value = "Add a new credit card",
            response = SuccessCallback::class
    )
    @PostMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun add(@Valid @RequestBody creditCard: CreditCard): ResponseEntity<Any> {

        /*return if(binding.hasErrors()) {
            val errors = ArrayList<RequiredFieldCallback>()

            binding.fieldErrors.forEach { errors.add(
                RequiredFieldCallback(it.field, it.defaultMessage)
            ) }

            val apiError = ApiFieldError(HttpStatus.BAD_REQUEST, "", errors)

            ResponseEntity(apiError, HttpStatus.BAD_REQUEST)
        }else {
            ResponseEntity(SuccessCallback("credit_card_created","Credit Card created with successful",genericRandom.getRandomInt()), HttpStatus.CREATED)
        }*/
        return ResponseEntity(SuccessCallback("credit_card_created","Credit Card created with successful",genericRandom.getRandomInt()), HttpStatus.CREATED)
    }
}