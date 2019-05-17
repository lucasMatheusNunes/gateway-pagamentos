package com.gateway.pagamentos.gateway.entity


import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size


 @Entity
 @Table(name = "transaction")
 class Transaction(
 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Int,

    @Column
    private val amount: Int, //Valor total a ser cobrado (em centavos). Ex: R$14,99 = 1499

    @Column
    private val card_hash: String, //Representação segura dos dados de cartão de crédito

    @Column
    private val installments: Int, //Número de parcelas a serem cobradas no cartão de crédito


    @Column
    private val payment_method:String, //credit_card - Meio de pagamento que será utilizado


    @Column
    private val postback_url: String, //URL para receber notificações sobre alterações no status da transação

    @Size(max=13)
    @Column
    private val soft_descriptor: String, //Texto (de até 13 caracteres, somente letras e números) que aparecerá na fatura do cartão do cliente ao lado do nome da sua loja

    @Column
    private val customer: String, //Objeto que deve possuir as informações do cliente. Obrigatório com o antifraude habilitado.

    @Column
    private val billing: String, //Objeto que deve possuir as informações de cobrança da transação. Obrigatório com o antifraude habilitado.

    @Column
    private val shipping: String, //Objeto que deve possuir as informações de envio do que foi comprado. Deve ser preenchido no caso da venda de um bem físico.

    @Column
    private val items: String, //Objeto que deve possuir as informações sobre os produtos comprados. Obrigatório com o antifraude habilitado.

    @Column
    private val metadata: String, //Objeto JSON para você receber dados de sua plataforma, como: id do pedido, descrição do produto/serviço, etc

    @Column
    private val session: String //Valor único que identifica a sessão do usuário acessando o site

 )
 {
 }
 

