package com.gateway.pagamentos.gateway.exception

import com.gateway.pagamentos.gateway.callback.RequiredFieldCallback
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValid(request: HttpServletRequest, ex : MethodArgumentNotValidException) : ResponseEntity<Any> {
        val errors = ArrayList<RequiredFieldCallback>()
        ex.bindingResult.fieldErrors.forEach {
            errors.add(
                RequiredFieldCallback(it.field, it.defaultMessage)
            )
        }

        val apiError = ApiFieldError(HttpStatus.BAD_REQUEST, "", errors)
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }
}