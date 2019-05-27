package com.gateway.pagamentos.gatewaypagamentos.controller

import com.gateway.pagamentos.gateway.controller.CreditCardController
import com.gateway.pagamentos.gateway.exception.WebApiExceptionHandler
import org.hamcrest.CoreMatchers
import org.hamcrest.core.IsNot.not
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
class CreditCardControllerTest {

    private var mockMvc: MockMvc? = null

    @Autowired
    private val creditCardController: CreditCardController? = CreditCardController()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(creditCardController)
            .setControllerAdvice(WebApiExceptionHandler())
            .build()
    }

    @Test
    @Throws(Exception::class)
    fun findOneTest() {
        this.mockMvc!!.perform(MockMvcRequestBuilders.get("/credit_card/1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addCreditSuccess() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA",
            "number" to "1234567890987",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "0420",
            "cvv" to "187"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id").isNotEmpty)
            .andExpect(jsonPath("$.id", not(0)))
    }

    @Test
    @Throws(Exception::class)
    fun addCreditEmpty() {
        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field", CoreMatchers.hasItem("clientId")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field", CoreMatchers.hasItem("statementDescriptor")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field", CoreMatchers.hasItem("number")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field", CoreMatchers.hasItem("holderName")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field", CoreMatchers.hasItem("holderDocument")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field", CoreMatchers.hasItem("expirationDate")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field", CoreMatchers.hasItem("cvv")))
    }

    @Test
    @Throws(Exception::class)
    fun addStatementDescriptorMore() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA ROCHA",
            "number" to "1234567890987",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "0420",
            "cvv" to "187"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isBadRequest)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addExpirationMore() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA",
            "number" to "1234567890987",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "042020",
            "cvv" to "187"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isBadRequest)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addExpirationRegex() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA",
            "number" to "1234567890987",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "04/2",
            "cvv" to "187"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isBadRequest)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addNumberMore() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA ROCHA",
            "number" to "12345678909876543212",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "0420",
            "cvv" to "187"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isBadRequest)
    }

    @Test
    @Throws(Exception::class)
    fun addNumberMin() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA ROCHA",
            "number" to "12345678",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "0420",
            "cvv" to "187"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isBadRequest)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addLastNumberMore() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA ROCHA",
            "number" to "12345678",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "0420",
            "cvv" to "187",
            "lastNumber" to "12345"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isBadRequest)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }
}