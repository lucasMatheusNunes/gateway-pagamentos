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
        val name: String,

        @Column
        val address: String//, //Address

       /*

        @OneToOne
        @JoinColumn(name = "transaction_id")
        val transaction: Transaction

        */

)
{

}