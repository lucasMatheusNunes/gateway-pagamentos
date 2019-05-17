package com.gateway.pagamentos.gateway.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*;
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@Entity
@Table(name="client")
class Client (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private var id: Int,

        @NotEmpty
        @Column(name = "real_name")
        private var realName: String,

        @Email
        private var email: String,

        @OneToMany(mappedBy = "client", cascade = arrayOf(CascadeType.ALL))
        private var address: List<Address>,

        @OneToMany(mappedBy = "client", cascade = arrayOf(CascadeType.ALL))
        private var phone: List<Phone>

    )
