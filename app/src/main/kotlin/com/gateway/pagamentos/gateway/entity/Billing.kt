package com.gateway.pagamentos.gateway.entity


import javax.persistence.*

@Entity
@Table(name = "billing")
class Billing(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Int,

        @Column
        val name: String,

        @Column
        val address: String//, //Address
)
{

}