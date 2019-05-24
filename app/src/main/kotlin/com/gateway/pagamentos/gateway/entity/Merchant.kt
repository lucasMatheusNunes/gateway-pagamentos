package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name="merchant")
@ApiModel(description = "Class representing a merchant that receive payments")
data class Merchant (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the merchant", example = "1", required = true)
        val id: Int,

        @Column(name = "real_name")
        @ApiModelProperty(notes = "Name of merchant", example = "John Mabell Rynyone", required = true)
        @field:NotEmpty
        val realName: String?,

        @ApiModelProperty(notes = "Email of merchant", example = "sample@mail.com")
        @field:Email
        val email: String?,

        @Column(name = "address_line_1")
        @ApiModelProperty(notes = "Principals datas of address, in this field must be informed: Number, Street, Neighborhood.", example = "728, John Colin, Center", required = true)
        @field:NotEmpty
        val addressLine1: String?,

        @Column(name = "address_line_2")
        @ApiModelProperty(notes = "Complement data of address", example = "Ap. 306, block E", allowEmptyValue = true)
        val addressLine2: String?,

        @Column(name = "zip_code")
        @ApiModelProperty(notes = "Zip code of address", example = "39674207", required = true)
        @field:[NotEmpty Size(min=3, max=10)]
        val zipCode: String?,

        @Column(name = "city")
        @ApiModelProperty(notes = "City of address", example = "Joinville", required = true)
        @field:NotEmpty
        val city: String?,

        @Column(name = "state")
        @ApiModelProperty(notes = "Code of State in format ISO 3166-2, more info about ISO 3166-2 in http://twixar.me/VSWn", example = "SC", required = true)
        @field:[NotEmpty Size(min=2, max = 2)]
        val state: String?,

        @Column(name = "country")
        @ApiModelProperty(notes = "Code of Country in format ISO 3166-1 alpha-2, more info about 3166-1 alpha-2 in http://twixar.me/ZXWn", example = "BR", required = true)
        @field:[NotEmpty Size(min=2, max = 2)]
        val country: String?,

        @Column(name = "bank_code")
        @ApiModelProperty(notes = "Bank code: 001 (Banco do Brasil S.A.); 033 (Santander); 104 (Caixa Econômica Federal); 237 (Bradesco); 341 (Itau);", example = "033", required = true)
        @field:[NotEmpty Size(min = 1, max = 3)]
        val bankCode: String?,

        @Column(name = "bank_branch_number")
        @ApiModelProperty(notes = "Branch number", example = "12345", required = true)
        @field:[NotEmpty]
        val bankBranchNumber: String?,

        @Column(name = "bank_branch_check_digit")
        @ApiModelProperty(notes = "Branch check digit", example = "3", required = true)
        @field:[NotNull Max(9)]
        val bankBranchCheckDigit: Int?,

        @Column(name = "bank_account_number")
        @ApiModelProperty(notes = "Account number", example = "54321", required = true)
        @field:[NotEmpty]
        val bankAccountNumber: String?,

        @Column(name = "bank_account_check_digit")
        @ApiModelProperty(notes = "Account check digit", example = "2", required = true)
        @field:[NotNull Max(9)]
        val bankAccountCheckDigit: Int?,

        @Column(name = "document_type")
        @ApiModelProperty(notes = "Document type: 1 (CPF); 2 (CNPJ)", example = "2", required = true)
        @field:[NotNull Min(1) Max(2)]
        val documentType: Int?,

        @Column(name = "document")
        @ApiModelProperty(notes = "Document, this field depends of value the document_type field", example = "98765432109", required = true)
        @field:[NotEmpty]
        val document: String?,

        @Column(name = "bank_account_type")
        @ApiModelProperty(notes = "Type account: 1 (Checking account); 2 (Savings account); 3 (Checking account joint); 4 (Savings account joint);", example = "1", required = true)
        @field:[NotNull Min(1) Max(4)]
        val bankAccountType: Int?,

        @Column(name = "phone_country_code")
        @ApiModelProperty(notes = "Country code", example = "55", required = true)
        @field:[NotEmpty Size(min = 1, max = 7)]
        val phoneCountryCode: String?,

        @Column(name = "phone_number")
        @ApiModelProperty(notes = "Number", example = "000000000", required = true)
        @field:[NotEmpty]
        val phoneNumber: String?,

        @Column(name = "phone_area_code")
        @ApiModelProperty(notes = "Area code", example = "47", required = true)
        @field:[NotNull]
        val phoneAreaCode: Int?,

        @Column(name = "token")
        @ApiModelProperty(notes = "Token of client for using in requests")
        val token : String?
    )
