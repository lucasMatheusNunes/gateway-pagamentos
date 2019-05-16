package com.gateway.pagamentos.gateway.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "person")
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Int,

    @NotNull
    @Size(min=2, max=30)
    @Column(name = "first_name")
    private val firstName: String,

    @NotNull
    @Column(name = "last_name")
    private val lastName: String
){

}


