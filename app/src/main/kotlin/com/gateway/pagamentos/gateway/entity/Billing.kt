package com.gateway.pagamentos.gateway.entity


import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size


@Entity
@Table(name = "billing")
class Billing(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Int,

        @Column
        private val name: String,

        @Column
        private val address: String, //Address

        @OneToOne
        val transaction: Transaction


)
{

}