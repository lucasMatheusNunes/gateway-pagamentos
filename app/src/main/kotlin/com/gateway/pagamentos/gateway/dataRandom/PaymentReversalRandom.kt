package com.gateway.pagamentos.gateway.dataRandom

import com.gateway.pagamentos.gateway.entity.PaymentReversal
import io.codearte.jfairy.Fairy

class PaymentReversalRandom {

    private val dataRandomPerson : Fairy = Fairy.create()

    fun getAll(qtde : Long) : ArrayList<PaymentReversal> {

        val listMerchants = ArrayList<PaymentReversal>()
        var numberOfRegisters : Int = if(qtde > 0) qtde.toInt() else 5

        for (x in 1..numberOfRegisters) {
            listMerchants.add(getById(x))
        }

        return listMerchants
    }

    fun getById(id : Int) : PaymentReversal {

        val merchantData = PaymentReversal(id,
                dataRandomPerson.baseProducer().randomInt(9999),
                dataRandomPerson.baseProducer().randomInt(9999),
                dataRandomPerson.baseProducer().randomInt(9999)
        )

        return merchantData
    }
}