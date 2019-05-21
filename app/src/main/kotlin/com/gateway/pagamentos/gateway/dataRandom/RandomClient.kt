package com.gateway.pagamentos.gateway.dataRandom

import com.gateway.pagamentos.gateway.entity.Client
import io.codearte.jfairy.Fairy

class RandomClient {

    fun getAll(qtde : Long) : ArrayList<Client> {

        var numberOfRegisters : Int
        val fairy : Fairy = Fairy.create()
        val listClients = ArrayList<com.gateway.pagamentos.gateway.entity.Client>()

        if(qtde > 0)
            numberOfRegisters = qtde.toInt()
        else
            numberOfRegisters = 5

        for (x in 1..numberOfRegisters) {

            val dataRandomPerson : Fairy = fairy

            val clientDat = com.gateway.pagamentos.gateway.entity.Client(x,
                    dataRandomPerson.person().fullName,
                    dataRandomPerson.person().email,
                    dataRandomPerson.person().address.addressLine1,
                    dataRandomPerson.person().address.addressLine2,
                    dataRandomPerson.person().address.postalCode,
                    dataRandomPerson.person().address.city,
                    "EX",
                    "US",
                    dataRandomPerson.baseProducer().randomInt(999),
                    dataRandomPerson.baseProducer().randomInt(99999),
                    dataRandomPerson.baseProducer().randomInt(9),
                    dataRandomPerson.baseProducer().randomInt(99999),
                    dataRandomPerson.baseProducer().randomInt(9),
                    dataRandomPerson.baseProducer().randomInt(2),
                    dataRandomPerson.person().passportNumber,
                    dataRandomPerson.baseProducer().randomInt(4),
                    dataRandomPerson.baseProducer().randomInt(99),
                    dataRandomPerson.person().telephoneNumber,
                    dataRandomPerson.baseProducer().randomInt(99))

            listClients.add(clientDat)
        }

        return listClients
    }
}