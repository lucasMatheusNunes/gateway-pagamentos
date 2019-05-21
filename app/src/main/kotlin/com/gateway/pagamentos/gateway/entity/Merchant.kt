package com.gateway.pagamentos.gateway.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import io.swagger.models.auth.In
import javax.persistence.*;
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name="merchant")
@ApiModel(description = "Class representing a merchant that receive payments")
data class Merchant (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the merchant", example = "1", required = true)
        val id: Int,

        @NotEmpty
        @Column(name = "real_name")
        @ApiModelProperty(notes = "Name of merchant", example = "John Mabell Rynyone", required = true)
        var realName: String,

        @Email
        @ApiModelProperty(notes = "Email of merchant", example = "sample@mail.com", allowEmptyValue = true)
        val email: String = "",

        @NotEmpty
        @Column(name = "address_line_1")
        @ApiModelProperty(notes = "Principals datas of address, in this field must be informed: Number, Street, Neighborhood.", example = "728, John Colin, Center", required = true)
        val addressLine1: String,

        @Column(name = "address_line_2")
        @ApiModelProperty(notes = "Complement data of address", example = "Ap. 306, block E", allowEmptyValue = true)
        val addressLine2: String = "",

        @NotNull
        @Column(name = "zip_code")
        @ApiModelProperty(notes = "Zip code of address", example = "39674207", required = true)
        val zipCode: String,

        @NotEmpty
        @Column(name = "city")
        @ApiModelProperty(notes = "City of address", example = "Joinville", required = true)
        val city: String,

        @NotEmpty
        @Column(name = "state")
        @ApiModelProperty(notes = "Code of State in format ISO 3166-2, more info about ISO 3166-2 in http://twixar.me/VSWn", example = "SC", required = true)
        val state: String,

        @NotEmpty
        @Column(name = "country")
        @ApiModelProperty(notes = "Code of Country in format ISO 3166-1 alpha-2, more info about 3166-1 alpha-2 in http://twixar.me/ZXWn", example = "BR", required = true)
        val country: String,

        @NotEmpty
        @Column(name = "bank_code")
        @ApiModelProperty(notes = "Bank code: 001 (Banco do Brasil S.A.); 033 (Santander); 104 (Caixa Econômica Federal); 237 (Bradesco); 341 (Itau);", example = "033", required = true)
        val bankCode: Int,

        @NotEmpty
        @Column(name = "bank_branch_number")
        @ApiModelProperty(notes = "Branch number", example = "12345", required = true)
        val bankBranchNumber: Int,

        @NotEmpty
        @Column(name = "bank_branch_check_digit")
        @ApiModelProperty(notes = "Branch check digit", example = "3", required = true)
        val bankBranchCheckDigit: Int,

        @NotEmpty
        @Column(name = "bank_account_number")
        @ApiModelProperty(notes = "Account number", example = "54321", required = true)
        val bankAccountNumber: Int,

        @NotEmpty
        @Column(name = "bank_account_check_digit")
        @ApiModelProperty(notes = "Account check digit", example = "2", required = true)
        val bankAccountCheckDigit: Int,

        @NotEmpty
        @Column(name = "document_type")
        @ApiModelProperty(notes = "Document type: 1 (CPF); 2 (CNPJ)", example = "2", required = true)
        val documentType: Int,

        @NotEmpty
        @Column(name = "document")
        @ApiModelProperty(notes = "Document, this field depends of value the document_type field", example = "98765432109", required = true)
        val document: String,

        @NotEmpty
        @Column(name = "bank_account_type")
        @ApiModelProperty(notes = "Type account: 1 (Chain account); 2 (Savings account); 3 (Chain account joint); 4 (Savings account joint);", example = "1", required = true)
        val bankAccountType: Int,

        @NotEmpty
        @Column(name = "phone_country_code")
        @ApiModelProperty(notes = "Country code", example = "55", required = true)
        val phoneCountryCode: Int,

        @NotEmpty
        @Column(name = "phone_number")
        @ApiModelProperty(notes = "Number", example = "000000000", required = true)
        val phoneNumber: String,

        @NotEmpty
        @Column(name = "phone_area_code")
        @ApiModelProperty(notes = "Area code", example = "47", required = true)
        val phoneAreaCode: Int,

        @Column(name = "token")
        @ApiModelProperty(notes = "Token of client for using in requests")
        val token : String = ""
    )
