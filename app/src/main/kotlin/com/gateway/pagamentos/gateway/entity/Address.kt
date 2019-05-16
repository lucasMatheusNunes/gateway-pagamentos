package com.gateway.pagamentos.gateway.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name="address")
class Address (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Int,

        @NotEmpty
        @Column(name = "line_1")
        private val line1: String,

        @Column(name = "line_2")
        private val line2: String,

        @NotNull
        @Column(name = "zip_code")
        private val zipCode: Int,

        @NotEmpty
        @Column(name = "city")
        private val city: String,

        @NotEmpty
        @Column(name = "state")
        private val state: String,

        @NotEmpty
        @Column(name = "country")
        private val country: String

    )