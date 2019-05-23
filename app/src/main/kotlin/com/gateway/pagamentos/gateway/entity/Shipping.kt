package com.gateway.pagamentos.gateway.entity


import org.jetbrains.annotations.NotNull
import javax.persistence.*


@Entity
@Table(name = "shipping")
class Shipping(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Int,

    /**
     * Obrigatório. Nome da entidade de cobrança
     */
    @NotNull
    @Column
    val name: String,

    /**
     * Obrigatório. Taxa de envio cobrada do comprador. Exemplo, se taxa de envio = R$10,03, o valor deve ser fornecido como ‘1003’
     */
    @NotNull
    @Column
    val fee: Int,

    /**
     * Data de entrega. Estimativa fornecida no formato AAAA-MM-DD
     */
    @Column
    val delivery_date: String,

    /**
     * Entrega expressa. Se for entrega expressa, ‘true’ (sim). Caso contrário, ‘false’ (não)
     */
    @Column
    val expedited: Boolean,

    /**
     * Address Object Obrigatório. Dados do endereço de envio. Objeto descrito
     */
    @NotNull
    @Column
    val address: String //,

    /*
       @OneToOne
       @JoinColumn(name = "transaction_id")
       val transaction: Transaction

       */


)
{

}