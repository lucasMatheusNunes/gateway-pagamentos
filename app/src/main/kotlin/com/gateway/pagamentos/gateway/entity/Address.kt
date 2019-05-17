package com.gateway.pagamentos.gateway.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
class Address (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private var id: Int,

        @NotEmpty
        @Column(name = "line_1")
        private var line1: String,

        @Column(name = "line_2")
        private var line2: String,

        @NotNull
        @Column(name = "zip_code")
        private var zipCode: Int,

        @NotEmpty
        @Column(name = "city")
        private var city: String,

        @NotEmpty
        @Column(name = "state")
        private var state: String,

        @NotEmpty
        @Column(name = "country")
        private var country: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_client")
        var client: Client

    )