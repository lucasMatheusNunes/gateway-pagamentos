package com.gateway.pagamentos.gateway.controller


import com.gateway.pagamentos.gateway.entity.Transaction
import com.gateway.pagamentos.gateway.entity.Billing
import com.gateway.pagamentos.gateway.entity.Shipping
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/transaction")
@Api(description = "REST Api related to transaction entity")
class TransactionController {


    val billing = Billing ( 1, "name", "address object" );
    val shipping = Shipping ( 1 , "entidade de cobrança", 1 , "2019-05-30", true , "Address Object"   );


    @ApiOperation(
            value = "Get transaction entity",
            response = Transaction::class
    )
    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getTransactionById(@PathVariable(value = "id") transactionId: Int): ResponseEntity<Transaction> {


         val transaction = Transaction(
                transactionId ,
                "21/05/2019 10:49" ,
                "21/05/2019 10:49" ,
                15900 ,
                15900 ,
                "processing" ,
                "" ,
                "" ,
                "rede" ,
                "1" ,
                "" , "" , "Descrição do loj" ,
                "1", "", 15900, 0, 1, 315, "João Silva", "1234", "jhl254359ykjhfs876543kjwt8734",
                "", "", "customer",
                 billing,
                 shipping,
                "items description",
                "",
                ""
        );

        return ResponseEntity.ok().body(transaction)

    }

    /*
    @ApiOperation(
            value = "Get transaction list ",
            response = Transaction::class
    )


    @GetMapping("/", produces = arrayOf("application/json"))
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getTransactionList(@RequestParam(value = "page_items", defaultValue = "", required = false) page_items: Int?,
                           @RequestParam(value = "status", defaultValue = "", required = false) status: String,
                           @RequestParam(value = "initialDateCreate", defaultValue = "", required = false) initialDateCreate: String,
                           @RequestParam(value = "endDateCreate", defaultValue = "", required = false) endDateCreate: String,
                           @RequestParam(value = "initialDateUpdate", defaultValue = "", required = false) initialDateUpdate: String,
                           @RequestParam(value = "endDateUpdate", defaultValue = "", required = false) endDateUpdate: String,
                           @RequestParam(value = "installments", defaultValue = "", required = false) installments: Int?,
                           @RequestParam(value = "amount", defaultValue = "", required = false) amount: Int?,
                           @RequestParam(value = "card_holder_name", defaultValue = "", required = false) card_holder_name: String?,
                           @RequestParam(value = "card_last_digits", defaultValue = "", required = false) card_last_digits: Int?,
                           @RequestParam(value = "card_brand", defaultValue = "", required = false) card_brand: String): ResponseEntity<null> {

        return ResponseEntity.ok().body(null)
        */


}