package com.gateway.pagamentos.gatewaypagamentos.controller

import com.gateway.pagamentos.gateway.controller.PersonController
import org.json.JSONObject
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
class PersonControllerTest {

    @Autowired
    private var mockMvc: MockMvc? = null

    @Autowired
    private val personController: PersonController? = PersonController()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mockMvc = MockMvcBuilders.standaloneSetup(personController).build()
    }

    @Test
    @Throws(Exception::class)
    fun findOnePersonTest() {
        this.mockMvc!!.perform(MockMvcRequestBuilders.get("/person/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun findAllPersonsTest() {
        this.mockMvc!!.perform(MockMvcRequestBuilders.get("/person"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addPersonSuccess() {
        val person = mapOf(
            "name" to "JOSE SILVA", // String
            "email" to "josedasilva@teste.com", // String
            "addressLine1" to "", // String?
            "addressLine2" to "", // String?
            "zipCode" to "", // String?
            "city" to "", // String?
            "state" to "", // String?
            "country" to "", // String
            "documentType" to 1, // Int
            "document" to "1234567890987",// String
            "phoneCountryCode" to 55,// Int
            "phoneAreaCode" to 47, // Int
            "phoneNumber" to "99955-2222"// String
        );
        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(person).toString())
        )
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addPersonError() {
        val person = mapOf(
            "name" to "", // String
            "email" to "josedasilva@teste.com", // String
            "addressLine1" to "",  // String?
            "addressLine2" to "",  // String?
            "zipCode" to "",  // String?
            "city" to "", // String?
            "state" to "", // String?
            "country" to "", // String
            "documentType" to 1, // Int
            "document" to "1234567890987",// String
            "phoneCountryCode" to 55, // Int
            "phoneAreaCode" to 47, // Int
            "phoneNumber" to "999552222"  // String
        );
        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(person).toString())
        )
            .andExpect(status().is4xxClientError())
        println("Persons tests completed")
    }

}
