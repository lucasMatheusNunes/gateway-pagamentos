package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Max
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name="credit_card")
@ApiModel(description = "Class representing a credit card")
data class CreditCard (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the credit card", example = "1", required = true)
        val id: Int,

        @field:NotNull(message = "client is required")
        @Column(name = "client_id")
        @ApiModelProperty(notes = "Client of Credit Card", example = "1", required = true)
        val clientId: Int?,

        @field:[NotEmpty Size(min=1, max = 13)]
        @Column(name = "statement_descriptor")
        @ApiModelProperty(notes = "statement descriptor of the credit card", example = "JOSE SILVA", required = true)
        val statementDescriptor: String?,

        @field:[NotEmpty Size(min=13, max = 19)]
        @Column(name = "number")
        @ApiModelProperty(notes = "number of the credit card", example = "1234567890987", required = true)
        val number: String?,

        @field:NotEmpty
        @Column(name = "holder_name")
        @ApiModelProperty(notes = "holder name of the credit card", example = "JOSE SILVA", required = true)
        val holderName: String?,

        @field:NotEmpty
        @Column(name = "holder_document")
        @ApiModelProperty(notes = "holder document of the credit card", example = "10188607030", required = true)
        val holderDocument: String?,

        @field:[NotEmpty Pattern(regexp="^[0-9]{4}",message="length must be 4")]
        @Column(name = "expiration_date")
        @ApiModelProperty(notes = "expiration date of the credit card", example = "0420", required = true)
        val expirationDate: String?,

        @field:[NotNull Max(999)]
        @Column(name = "cvv")
        @ApiModelProperty(notes = "cvv of the credit card", example = "187", required = true)
        val cvv: Int?,

        @Size(max = 4)
        @Column(name = "last_number")
        @ApiModelProperty(notes = "last number of the credit card", example = "1234", required = true)
        val lastNumber: String?
)