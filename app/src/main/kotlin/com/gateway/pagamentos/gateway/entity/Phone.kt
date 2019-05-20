package com.gateway.pagamentos.gateway.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "phone")
data class Phone (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,

        @NotEmpty
        @Column(name = "type")
        //1 = home phone, 2 = mobile phone
        val type: String,

        @NotEmpty
        @Column(name = "country_code")
        val countryCode: String,

        @NotEmpty
        @Column(name = "number")
        val number: String,

        @NotEmpty
        @Column(name = "area_code")
        val areaCode: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_client")
        val client: Client
    )