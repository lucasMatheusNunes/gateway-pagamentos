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

    @ApiOperation(
            value = "Get transaction entity",
            response = Transaction::class
    )
    @GetMapping("/{id}", produces = arrayOf("application/json"))
    fun getTransactionById(@PathVariable(value = "id") transactionId: Int): ResponseEntity<Transaction> {

        val billing = Billing ( 1, "name", "address object" );
        val shipping = Shipping ( 1 , "entidade de cobrança", 1 , "2019-05-30", true , "Address Object"   );

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
}