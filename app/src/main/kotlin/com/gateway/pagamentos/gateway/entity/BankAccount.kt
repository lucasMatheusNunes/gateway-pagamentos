package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "account_bank")
@ApiModel(description = "Class representing a Bank Account of client")
data class BankAccount (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the Account bank", example = "1", required = true)
        val id: Int,

        @NotEmpty
        @Column(name = "bank_code")
        @ApiModelProperty(notes = "Bank code: 001 (Banco do Brasil S.A.); 033 (Santander); 104 (Caixa Econômica Federal); 237 (Bradesco); 341 (Itau);", example = "033", required = true)
        val bankCode: String,

        @NotEmpty
        @Column(name = "branch_number")
        @ApiModelProperty(notes = "Branch number", example = "12345", required = true)
        val branchNumber: String,

        @NotEmpty
        @Column(name = "branch_check_digit")
        @ApiModelProperty(notes = "Branch check digit", example = "3", required = true)
        val branchCheckDigit: String,

        @NotEmpty
        @Column(name = "account_number")
        @ApiModelProperty(notes = "Account number", example = "54321", required = true)
        val accountNumber: String,

        @NotEmpty
        @Column(name = "account_check_digit")
        @ApiModelProperty(notes = "Account check digit", example = "2", required = true)
        val accountCheckDigit: String,

        @NotEmpty
        @Column(name = "document_type")
        @ApiModelProperty(notes = "Document type: 1 (CPF); 2 (CNPJ)", example = "2", required = true)
        val documentType: Int,

        @NotEmpty
        @Column(name = "document")
        @ApiModelProperty(notes = "Document, this field depends of value the document_type field", example = "98765432109", required = true)
        val document: String,

        @NotEmpty
        @Column(name = "account_type")
        @ApiModelProperty(notes = "Type account: 1 (Chain account); 2 (Savings account); 3 (Chain account joint); 4 (Savings account joint);", example = "1", required = true)
        val accountType: Int,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_client")
        @ApiModelProperty(notes = "Id of client responsible by bank account", example = "1", required = true)
        val client: Client
    )
