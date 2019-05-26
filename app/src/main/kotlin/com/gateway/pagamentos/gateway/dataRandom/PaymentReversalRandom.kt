package com.gateway.pagamentos.gateway.dataRandom

import com.gateway.pagamentos.gateway.entity.PaymentReversal
import io.codearte.jfairy.Fairy

class PaymentReversalRandom {

    private val dataRandomPerson : Fairy = Fairy.create()

    fun getAll() : ArrayList<PaymentReversal> {

        val listMerchants = ArrayList<PaymentReversal>()
        var numberOfRegisters : Int =  5

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