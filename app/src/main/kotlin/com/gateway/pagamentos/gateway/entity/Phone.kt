package com.gateway.pagamentos.gateway.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "phone")
class Phone (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private var id: Int,

        @NotEmpty
        @Column(name = "type")
        //1 = home phone, 2 = mobile phone
        private var type: String,

        @NotEmpty
        @Column(name = "country_code")
        private var countryCode: String,

        @NotEmpty
        @Column(name = "number")
        private var number: String,

        @NotEmpty
        @Column(name = "area_code")
        private var areaCode: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_client")
        var client: Client
    )