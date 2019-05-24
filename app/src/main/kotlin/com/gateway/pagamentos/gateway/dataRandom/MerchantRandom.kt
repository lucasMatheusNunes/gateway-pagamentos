package com.gateway.pagamentos.gateway.dataRandom

import com.gateway.pagamentos.gateway.entity.Merchant
import io.codearte.jfairy.Fairy

class MerchantRandom {

    private val dataRandomPerson : Fairy = Fairy.create()

    fun getAll(qtde : Long) : ArrayList<Merchant> {

        val listMerchants = ArrayList<Merchant>()
        val numberOfRegisters : Int = if(qtde > 0) qtde.toInt() else 5

        for (x in 1..numberOfRegisters) {
            listMerchants.add(getById(x))
        }

        return listMerchants
    }

    fun getById(id : Int) : Merchant {

        return Merchant(id,
                dataRandomPerson.person().fullName,
                dataRandomPerson.person().email,
                dataRandomPerson.person().address.addressLine1,
                dataRandomPerson.person().address.addressLine2,
                dataRandomPerson.person().address.postalCode,
                dataRandomPerson.person().address.city,
                "EX",
                "US",
                dataRandomPerson.baseProducer().randomInt(999).toString(),
                dataRandomPerson.baseProducer().randomInt(99999).toString(),
                dataRandomPerson.baseProducer().randomInt(9),
                dataRandomPerson.baseProducer().randomInt(99999).toString(),
                dataRandomPerson.baseProducer().randomInt(9).toString(),
                dataRandomPerson.baseProducer().randomInt(2),
                dataRandomPerson.person().passportNumber,
                dataRandomPerson.baseProducer().randomInt(4),
                dataRandomPerson.baseProducer().randomInt(99).toString(),
                dataRandomPerson.person().telephoneNumber,
                dataRandomPerson.baseProducer().randomInt(99),
                "")
    }

    fun getRandomToken() : String {
        return dataRandomPerson.textProducer().randomString(50)
    }

    fun getRandomInt() : Int {
        return dataRandomPerson.baseProducer().randomInt(10000)
    }
}