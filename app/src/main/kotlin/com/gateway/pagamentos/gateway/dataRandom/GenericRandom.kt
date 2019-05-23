package com.gateway.pagamentos.gateway.dataRandom

import io.codearte.jfairy.Fairy

class GenericRandom {

    private val dataRandomPerson : Fairy = Fairy.create()

    fun getRandomToken() : String {
        return dataRandomPerson.textProducer().randomString(50)
    }

    fun getRandomInt() : Int {
        return dataRandomPerson.baseProducer().randomInt(10000)
    }
}