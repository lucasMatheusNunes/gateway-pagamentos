package com.gateway.pagamentos.gateway.exception

import com.gateway.pagamentos.gateway.callback.RequiredFieldCallback
import org.springframework.http.HttpStatus

class ApiFieldError (
    var status: HttpStatus,
    var clientMessage: String,
    var errors: List<RequiredFieldCallback>,
    var developerMessage: String? = null
    ) {
        constructor(status: HttpStatus, clientMessage: String, error: RequiredFieldCallback, developerMessage: String? = null) :
        this(status, clientMessage, arrayListOf<RequiredFieldCallback>(error), developerMessage)
    }