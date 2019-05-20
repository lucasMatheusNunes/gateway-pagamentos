package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*;
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@Entity
@Table(name="client")
@ApiModel(description = "Class representing a client that receive payments")
data class Client (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the client", example = "1", required = true)
        val id: Int,

        @NotEmpty
        @Column(name = "real_name")
        @ApiModelProperty(notes = "Name of client", example = "John Mabell Rynyone", required = true)
        var realName: String,

        @Email
        @ApiModelProperty(notes = "Email of client", example = "sample@mail.com")
        val email: String,

        @OneToMany(mappedBy = "client", cascade = arrayOf(CascadeType.ALL))
        @ApiModelProperty(notes = "Client address array")
        val address: List<Address>,

        @OneToMany(mappedBy = "client", cascade = arrayOf(CascadeType.ALL))
        @ApiModelProperty(notes = "Client phones array")
        val phone: List<Phone>,

        @OneToMany(mappedBy = "client", cascade = arrayOf(CascadeType.ALL))
        @ApiModelProperty(notes = "Client bank account array")
        val bankAccount: List<BankAccount>

    )
