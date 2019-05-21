package com.gateway.pagamentos.gateway.callback

import io.swagger.annotations.Api
import io.swagger.annotations.ApiModelProperty

@Api(description = "Class used for info from Success Callback")
class SuccessCallback (
        @ApiModelProperty(notes = "Internal status with abbreviated info the operation", example = "object_created")
        val status : String,

        @ApiModelProperty(notes = "Message more long of the operation", example = "Object created with successful")
        val message : String,

        @ApiModelProperty(notes = "Unique identifier of the entity in question", example = "8")
        val id : Int,

        @ApiModelProperty(notes = "Token for validation of client")
        val token: String? = null
)