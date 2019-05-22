package com.gateway.pagamentos.gateway.controller

import com.gateway.pagamentos.gateway.entity.Person

import com.gateway.pagamentos.gateway.callback.SuccessCallback
import com.gateway.pagamentos.gateway.dataRandom.RandomPerson

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/person")
@Api(description = "REST Api related to person entity")
class PersonController {

    private var randomPerson : RandomPerson = RandomPerson()

    @ApiOperation(
        value = "Post person entity",
        response = SuccessCallback::class
    )

     @PostMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
     fun add(@Valid @RequestBody person: Person): ResponseEntity<SuccessCallback>{

        return ResponseEntity(SuccessCallback("person_created","Person created with successful",person.id), HttpStatus.CREATED)
     }

     @GetMapping(produces = arrayOf("application/json"))
     fun getAll() : ArrayList<Person> {

        var qtde = 5
        return randomPerson.getAll(qtde)
     }

    @ApiOperation(
        value = "Get person by id",
        response = Person::class
    )

    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getOne(@PathVariable("id") id: Int) : Person{
        return randomPerson.getById(id)
    }


}