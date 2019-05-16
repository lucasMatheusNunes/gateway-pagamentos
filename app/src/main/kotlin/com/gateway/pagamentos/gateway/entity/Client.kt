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
        private val id: Int,

        @NotEmpty
        @Column(name = "real_name")
        private val realName: String,

        @Email
        private val email: String
    )
