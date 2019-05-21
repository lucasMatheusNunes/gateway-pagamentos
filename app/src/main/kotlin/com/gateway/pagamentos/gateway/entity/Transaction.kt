package com.gateway.pagamentos.gateway.entity


import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore


 @Entity
 @Table(name = "transaction")
 @ApiModel(description = "Class representing payment transactions and refund of payments")

 class Transaction(
 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Unique identifier of the transaction", example = "1", required = true)
    private val id: Int,

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @Column(updatable=false)
    //@CreatedDate
    @ApiModelProperty(notes = "date of create transaction", required = true)
    val dataCreate: String,

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    //@LastModifiedDate
    @ApiModelProperty(notes = "date of update transaction", required = true)
    val dataUpdate: String,

    @Column
    @ApiModelProperty(notes = "\n" +
            "Total amount to be charged (in cents). Ex: R$ 14.99 = ", example = "14990", required = true)
    val amount: Int,

    @Column
    @ApiModelProperty(notes = "Value in cents authorized in the transaction, always less than or equal to amount.",
            example = "14990", required = true)
    val authorized_amount: Int,

    @Column
    @ApiModelProperty(notes = "Represents the state of the transaction. With each update in transaction processing," +
            " this property is changed and, if you are using a postback_url, your servers are notified of those " +
            "updates. Possible values: processing, authorized, paid, refunded, waiting_payment, pending_refund," +
            " refused.", example = "1", required = true)
    val status: String,

    @Column
    @ApiModelProperty(notes = "Reason why the transaction was declined." +
            "Possible values: acquirer, antifraud, internal_error, no_acquirer, acquirer_timeout",
            example = "antifraud", required = true)
    val refuse_reason: String,

    @Column
    @ApiModelProperty(notes =
            "Agent responsible for validating or canceling the transaction. " +
                    "Possible values: acquirer, antifraud, internal_error, no_acquirer, acquirer_timeout", example = "antifraud", required = true)
    val status_reason: String,

    @Column
    @ApiModelProperty(notes = "Acquirer responsible for processing the transaction." +
            "Possible values: development (in test environment),  stone, cielo, rede.", example = "cielo",
            required = true)
    val acquirer_name: String,


    @Column
    @ApiModelProperty(notes = "ID of the acquirer responsible for processing the transaction.",
            example = "1", required = true)
    val acquirer_id: String,

    @Column
    @ApiModelProperty(notes = "Message from the acquirer regarding the status of the transaction.",
            required = true)
    val acquirer_response_code: String,

    @Column
    @ApiModelProperty(notes = "Authorization code returned of card flag.", required = true)
    val authorization_code: String,

    @Column
    @ApiModelProperty(notes = "text that will appear on the customer invoice after the store name. " +
            "Limit of 13 characters.", example = "1", required = true)
    val soft_descriptor: String,

    @Column
    @ApiModelProperty(notes ="Code that identifies the transaction in the acquirer.")
    val tid: String,

    @Column
    @ApiModelProperty(notes = "", example = "1", required = true)
    val nsu: String,

    @Column
    @ApiModelProperty(notes = "Value in cents captured in the transaction," +
            " always less than or equal to an authorized value.")
    val paid_amount: Int,

    @Column
    @ApiModelProperty(notes = "refunded amount", example = "14000", required = true)
    val refunded_amount: Int,

    @Column
    @ApiModelProperty(notes = "Number of installments to be charged. Minimum 1 and Maximum 12.", example = "1", required = true)
    val installments: Int,

    @Column
    @ApiModelProperty(notes = "Cost of the transaction for the merchant, involving processing and anti-fraud.",
            example = "380", required = true)
    val cost: Int,

    @Column
    @ApiModelProperty(notes = "Name of cardholder.", example = "João Silva", required = true)
    val card_holder_name: String,

    @Column
    @ApiModelProperty(notes = "Last 4 digits of card", example = "5931", required = true)
    val card_last_digits: String,

    @Column
    @ApiModelProperty(notes = "Safe representation of credit card data", required = true)
    val card_hash: String,

    @Column
    @ApiModelProperty(notes = "Means of payment to be used", example = "credit_card", required = true)
    val payment_method:String,

    @Column
    @ApiModelProperty(notes = "URL to receive notifications about changes in transaction status.", required = true)
    val postback_url: String,

    @Column
    @ApiModelProperty(notes = "\n" +
            "Object that must have client information. Required with antifraud enabled.", required = true)
    val customer: String,

    @OneToOne(fetch = FetchType.LAZY)
    @ApiModelProperty(notes = "Object that must have the transaction billing information. " +
            "Required with antifraud enabled.", required = true)
    val billing: Billing,

    @OneToOne(fetch = FetchType.LAZY)
    @ApiModelProperty(notes = "Object that must have the shipping information of what was purchased. " +
            "Must be completed in the case of the sale of a physical property.", required = true)
    val shipping: Shipping,

    @Column
    @ApiModelProperty(notes = "Object that must have the information about the products purchased. " +
            "Required with antifraud enabled.", required = true)
    val items: String,


    @Column
    @ApiModelProperty(notes = "JSON object for you to receive the data of your platform, " +
            "such as: order id, product / service description, etc.", required = true)
    private val metadata: String,

    @Column
    @ApiModelProperty(notes = "Unique value that identifies the user session accessing the site", required = true)
    private val session: String

 )
 {
 }

