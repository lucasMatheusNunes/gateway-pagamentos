package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "payment_reversal")
@ApiModel(description = "Class representing a payment reversal")
class PaymentReversal (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the payment reversal", example = "9")
        val id : Int,

        @Column(name = "id_merchant")
        @ApiModelProperty(notes = "Unique identifier reference of merchant", example = "6", required = true)
        @field:NotNull
        var idMerchant: Int?,

        @Column(name = "id_transaction")
        @ApiModelProperty(notes = "Unique identifier reference of transaction", example = "3", required = true)
        @field:NotNull
        var idTransaction : Int?,

        @Column(name = "amount")
        @ApiModelProperty(notes = "Value reversal, this value must be in cents", required = true)
        @field:NotNull
        var amount : Int?
)