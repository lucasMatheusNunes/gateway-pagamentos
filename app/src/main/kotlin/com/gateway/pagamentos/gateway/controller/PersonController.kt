package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.entity.Person
import com.gateway.pagamentos.gateway.dataRandom.PersonRandom
import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.callback.RequiredFieldCallback
import com.gateway.pagamentos.gateway.exception.ApiFieldError
import com.gateway.pagamentos.gateway.dataRandom.GenericRandom
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.validation.BindingResult
import javax.validation.Valid
import java.util.*

@RestController
@RequestMapping("/person")
@Api(description = "REST Api related to person entity")
class PersonController {

    private var personRandom: PersonRandom = PersonRandom()
    private var genericRandom: GenericRandom = GenericRandom()

    @ApiOperation(
        value = "Post person entity",
        response = SuccessCallback::class
    )

    @PostMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun add(@Valid @RequestBody person: Person, binding: BindingResult): ResponseEntity<Any> {
        return if (binding.hasErrors()) {
            val errors = ArrayList<RequiredFieldCallback>()
            binding.fieldErrors.forEach {
                errors.add(
                    RequiredFieldCallback(it.field, it.defaultMessage)
                )
            }
            val apiError = ApiFieldError(HttpStatus.BAD_REQUEST, "", errors)
            return ResponseEntity(apiError, HttpStatus.BAD_REQUEST)
        } else {
            return ResponseEntity(
                SuccessCallback(
                    "person_created",
                    "Person created with successful",
                    genericRandom.getRandomInt()
                ), HttpStatus.CREATED
            )
        }
    }

    @GetMapping(produces = arrayOf("application/json"))
    fun getAll(): ArrayList<Person> {

        var qtde = 5
        return personRandom.getAll(qtde)
    }

    @ApiOperation(
        value = "Get person by id",
        response = Person::class
    )

    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getOne(@PathVariable("id") id: Int): Person {
        return personRandom.getById(id)
    }


}