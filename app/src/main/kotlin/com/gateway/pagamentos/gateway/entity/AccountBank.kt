package com.gateway.pagamentos.gateway.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "account_bank")
class AccountBank (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private var id: Int,

        @NotEmpty
        @Column(name = "bank_code")
        private var bankCode: String,

        @NotEmpty
        @Column(name = "branch_number")
        private var branchNumber: String,

        @NotEmpty
        @Column(name = "branch_check_digit")
        private var branchCheckDigit: String,

        @NotEmpty
        @Column(name = "account_number")
        private var accountNumber: String,

        @NotEmpty
        @Column(name = "account_check_digit")
        private var accountCheckDigit: String,

        @NotEmpty
        @Column(name = "document_type")
        //1 = CPF, 2 = CNPJ
        private var documentType: Int,

        @NotEmpty
        @Column(name = "document")
        private var document: String,

        @NotEmpty
        @Column(name = "account_type")
        //1 = Chain Account, 2 = Savings account, 3 = Chain account joint, 4 = Savings account joint
        private var accountType: Int
    )
