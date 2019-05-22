package com.gateway.pagamentos.gateway.dataRandom

import com.gateway.pagamentos.gateway.entity.Person
import io.codearte.jfairy.Fairy

class  RandomPerson {

    private val dataRandomPerson : Fairy = Fairy.create()

    fun getAll(qtde : Int) : ArrayList<Person> {

        val listPersons = ArrayList<Person>()
        var numberOfRegisters : Int = if(qtde > 0) qtde.toInt() else 5

        for (x in 1..numberOfRegisters) {
            listPersons.add(getById(x))
        }

        return listPersons
    }

    fun getById(id : Int) : Person {

        val personData = Person(id,
                dataRandomPerson.person().fullName,
                dataRandomPerson.person().email,
                dataRandomPerson.person().address.addressLine1,
                dataRandomPerson.person().address.addressLine2,
                dataRandomPerson.person().address.postalCode,
                dataRandomPerson.person().address.city,
                "EX",
                "US",
                dataRandomPerson.baseProducer().randomInt(2),
                dataRandomPerson.person().passportNumber,
                dataRandomPerson.baseProducer().randomInt(99),
                dataRandomPerson.person().telephoneNumber,
                dataRandomPerson.baseProducer().randomInt(99))

        return personData
    }

    fun getRandomToken() : String {
        return dataRandomPerson.textProducer().randomString(50)
    }

    fun getRandomInt() : Int {
        return dataRandomPerson.baseProducer().randomInt(10000)
    }
}
