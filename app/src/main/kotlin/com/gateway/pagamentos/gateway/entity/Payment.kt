package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModelProperty
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty

data class Payment (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the payment", example = "1", required = true)
        val id: Int,

        @NotEmpty
        @Column(name = "payment_method")
        @ApiModelProperty(notes = "Payment Method", example = "credit_card, voucher, ticket", required = true)
        val paymentMethod: String,

        @NotEmpty
        @Column(name = "amount")
        @ApiModelProperty(notes = "Amount of Payment", example = "1.99", required = true)
        val amount: Double,

        @NotEmpty
        @Column(name = "metadata")
        @ApiModelProperty(notes = "Metadata of Payment", example = "{\"description\":\"coffee\"}", required = true)
        val metadata: Map<String, String>,

        @NotEmpty
        @Column(name = "token")
        @ApiModelProperty(notes = "Token of client", example = "jhl254359ykjhfs876543kjwt8734", required = true)
        val token: String
)