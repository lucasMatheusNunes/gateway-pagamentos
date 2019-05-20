package com.gateway.pagamentos.gateway.entity

import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
data class Address (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(notes = "Unique identifier of the Address", example = "1", required = true)
        val id: Int,

        @NotEmpty
        @Column(name = "line_1")
        val line1: String,

        @Column(name = "line_2")
        val line2: String,

        @NotNull
        @Column(name = "zip_code")
        val zipCode: Int,

        @NotEmpty
        @Column(name = "city")
        val city: String,

        @NotEmpty
        @Column(name = "state")
        val state: String,

        @NotEmpty
        @Column(name = "country")
        val country: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_client")
        val client: Client

    )