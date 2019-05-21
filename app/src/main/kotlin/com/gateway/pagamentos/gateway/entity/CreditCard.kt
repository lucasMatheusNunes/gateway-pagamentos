package com.gateway.pagamentos.gateway.entity

import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(name="credit_card")
@ApiModel(description = "Class representing a credit card")
data class CreditCard (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the credit card", example = "1", required = true)
        val id: Int,

        @NotEmpty
        @Size(max = 13)
        @Column(name = "statement_descriptor")
        @ApiModelProperty(notes = "statement descriptor of the credit card", example = "JOSE SILVA", required = true)
        val statementDescriptor: String,

        @NotEmpty
        @Size(min = 13, max = 19)
        @Column(name = "number")
        @ApiModelProperty(notes = "number of the credit card", example = "1234567890987", required = true)
        val number: String,

        @NotEmpty
        @Column(name = "holder_name")
        @ApiModelProperty(notes = "holder name of the credit card", example = "JOSE SILVA", required = true)
        val holderName: String,

        @NotEmpty
        @Column(name = "holder_document")
        @ApiModelProperty(notes = "holder document of the credit card", example = "10188607030", required = true)
        val holderDocument: String,

        @NotEmpty
        @JsonFormat(pattern="dd/MM/yyyy HH:mm")
        @Column(name = "expiration_date")
        @ApiModelProperty(notes = "expiration date (unix timestamp) of the credit card", example = "dd/MM/yyyy HH:mm", required = true)
        val expirationDate: String,

        @NotEmpty
        @Size(min = 3)
        @Column(name = "cvv")
        @ApiModelProperty(notes = "cvv of the credit card", example = "187", required = true)
        val cvv: Int
)