package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name="payment")
@ApiModel(description = "Class representing a payment")
data class Payment (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the payment", example = "1", required = true)
        val id: Int,

        @field:NotEmpty(message = "payment_method is required")
        @Column(name = "payment_method")
        @ApiModelProperty(notes = "Payment Method: credit_card, voucher, ticket", example = "credit_card", required = true)
        val paymentMethod: String?,

        @field:NotNull(message = "credit_card_id is required")
        @Column(name = "credit_card_id")
        @ApiModelProperty(notes = "Credit Card of Payment", example = "1", required = true)
        val creditCardId: Int?,

        @field:NotNull(message = "mechant is required")
        @Column(name = "merchant_id")
        @ApiModelProperty(notes = "Merchant of Payment", example = "1", required = true)
        val merchantId: Int?,

        @field:NotNull(message = "client is required")
        @Column(name = "client_id")
        @ApiModelProperty(notes = "Client of Payment", example = "1", required = true)
        val clientId: Int?,

        @field:NotNull(message = "amount is required")
        @Column(name = "amount")
        @ApiModelProperty(notes = "amount of payment in cents", example = "199", required = true)
        val amount: Int?,

        @field:NotEmpty
        @Column(name = "metadata")
        @ApiModelProperty(notes = "Metadata of Payment", example = "coffee", required = true)
        val metadata: String?,

        @field:NotNull(message = "installments is required")
        @Column(name = "installments")
        @ApiModelProperty(notes = "installments of payment", example = "1", required = true)
        val installments: Int?
)