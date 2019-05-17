package com.gateway.pagamentos.gateway.entity

import com.gateway.pagamentos.gateway.entity.*

import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



 @Entity
 @Table(name = "transaction")
 class Transaction(
 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Int,

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @Column(updatable=false)
   // @CreationTimestamp
    val dataCreate: String,

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    //@UpdateTimestamp
    val dataUpdate: String,

    /**
     * Valor total a ser cobrado (em centavos). Ex: R$14,99 = 1499
     */
    @Column
    private val amount: Int,

    /**
     * Valor em centavos autorizado na transação, sempre menor ou igual a amount.
     */
    @Column
    private val authorized_amount: Int,


    /**
     * Representa o estado da transação. A cada atualização no processamento da transação, esta propriedade
     * é alterada e, caso você esteja usando uma postback_url, os seus servidores são notificados desses updates.
     * Valores possíveis: processing, authorized, paid, refunded, waiting_payment, pending_refund, refused .
     */
    @Column
    private val status: String,

    /**
     *  Motivo pelo qual a transação foi recusada.
     *  Valores possíveis: acquirer, antifraud, internal_error, no_acquirer, acquirer_timeout
     */
    @Column
    private val refuse_reason: String,

    /**
     * Agente responsável pela validação ou anulação da transação.
     * Valores possíveis: acquirer, antifraud, internal_error, no_acquirer, acquirer_timeout
     */
    @Column
    private val status_reason: String,

    /**
     *  Adquirente responsável pelo processamento da transação.
     *  Valores possíveis: development (em ambiente de testes), pagarme (adquirente Pagar.me), stone, cielo, rede.
     */
    @Column
    private val acquirer_name: String,


    /**
     * ID da adquirente responsável pelo processamento da transação.
     */
    @Column
    private val acquirer_id: String,

    /**
     * Mensagem de resposta da adquirente referente ao status da transação.
     */
    @Column
    private val acquirer_response_code: String,


    /**
     * Código de autorização retornado pela bandeira.
     */
    @Column
    private val authorization_code: String,


    /**
     * Texto que irá aparecer na fatura do cliente depois do nome da loja. Limite de 13 caracteres.
     */
    @Column
    private val soft_descriptor: String,

    /**
     * (tid e nsu) Código que identifica a transação na adquirente.
     */
    @Column
    private val tid: String,

    @Column
    private val nsu: String,

    /**
     * Valor em centavos capturado na transação, sempre menor ou igual a authorized_amount.
     */
    @Column
    private val paid_amount: Int,

    @Column
    private val refunded_amount: Int,

    /**
     *  Número de parcelas a serem cobradas. Mínimo 1 e Máximo 12.
     */
    @Column
    private val installments: Int,

    /**
     *  Custo da transação para o lojista, envolvendo processamento e antifraude.
     */
    @Column
    private val cost: Int,


    /**
     *  Nome do portador do cartão.
     */
    @Column
    private val card_holder_name: String,


    /**
     *  Últimos 4 dígitos do cartão.
     */
    @Column
    private val card_last_digits: String,

    /**
     * Representação segura dos dados de cartão de crédito
     */
    @Column
    private val card_hash: String,

    /**
     * (credit_card) - Meio de pagamento que será utilizado
     */
    @Column
    private val payment_method:String,

    /**
     * URL para receber notificações sobre alterações no status da transação.
     */
    @Column
    private val postback_url: String,


    /**
     * Objeto que deve possuir as informações do cliente. Obrigatório com o antifraude habilitado.
     */
    @Column
    private val customer: String,

    /**
     * Objeto que deve possuir as informações de cobrança da transação. Obrigatório com o antifraude habilitado.
     */

    @Column
    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private val billing: Billing,


    /**
     * Objeto que deve possuir as informações de envio do que foi comprado. Deve ser preenchido
     * no caso da venda de um bem físico.
     */
    @Column
    @OneToOne(mappedBy = "shipping", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private val shipping: Shipping,

    /**
     * Objeto que deve possuir as informações sobre os produtos comprados. Obrigatório com o antifraude habilitado.
     */
    @Column
    private val items: String,

    /**
     * Objeto JSON para você receber dados de sua plataforma, como: id do pedido, descrição do produto/serviço, etc
     */
    @Column
    private val metadata: String,

    /**
     * Valor único que identifica a sessão do usuário acessando o site
     */
    @Column
    private val session: String

 )
 {
 }

