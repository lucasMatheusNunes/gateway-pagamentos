package com.gateway.pagamentos.gatewaypagamentos.controller

import com.gateway.pagamentos.gateway.controller.MerchantController
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
class MerchantControllerTest {
    private var mockMvc: MockMvc? = null

    @Autowired
    private val merchantController: MerchantController? = MerchantController()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mockMvc = MockMvcBuilders.standaloneSetup(merchantController)
            .build()
    }

    @Test
    @Throws(Exception::class)
    fun getAllTest() {
        this.mockMvc!!.perform(MockMvcRequestBuilders.get("/merchant"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun getOneTest() {
        val idUrl: Int = 2

        this.mockMvc!!.perform(MockMvcRequestBuilders.get("/merchant/" + idUrl))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(idUrl))
    }

    @Test
    @Throws(Exception::class)
    fun addOnlyRequiredFieldsForSuccessTest() {
        val merchant = mapOf(
            "realName" to "Jose Silva",
            "addressLine1" to "10, rua tal, bairro tal",
            "state" to "SC",
            "zipCode" to "392839084",
            "city" to "Joinville",
            "country" to "BR",
            "documentType" to 1,
            "document" to "01451373000134",
            "phoneCountryCode" to 109,
            "phoneAreaCode" to 47,
            "phoneNumber" to 937501326,
            "bankBranchCheckDigit" to 6,
            "bankAccountType" to 3,
            "bankAccountCheckDigit" to "01",
            "bankAccountNumber" to 3487354598211,
            "bankBranchNumber" to "00000",
            "bankCode" to "001"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/merchant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(merchant).toString())
        )
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", not(0)))
            .andExpect(jsonPath("$.id").isNotEmpty)
    }

    @Test
    @Throws(Exception::class)
    fun addAllFieldsForSuccessTest() {
        val merchant = mapOf(
            "realName" to "Jose Silva",
            "email" to "email@mail.com",
            "addressLine1" to "10, rua tal, bairro tal",
            "addressLine2" to "Ap. 105, block U",
            "zipCode" to "392839084",
            "city" to "Joinville",
            "state" to "SC",
            "country" to "BR",
            "documentType" to 1,
            "document" to "01451373000134",
            "phoneCountryCode" to 109,
            "phoneAreaCode" to 47,
            "phoneNumber" to 937501326,
            "bankBranchCheckDigit" to 6,
            "bankAccountType" to 3,
            "bankAccountCheckDigit" to "01",
            "bankAccountNumber" to 3487354598211,
            "bankBranchNumber" to "00000",
            "bankCode" to "001"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/merchant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(merchant).toString())
        )
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", not(0)))
            .andExpect(jsonPath("$.id").isNotEmpty)
    }

    @Test
    @Throws(Exception::class)
    fun addAllFieldsInvalidsTest() {
        val merchant = mapOf(
            "realName" to "Jose Silva da Silva da Silva da Silva da Silva da Silva da Silvaa",
            "email" to "email",
            "addressLine1" to "rua",
            "zipCode" to "49291038229692081",
            "city" to "Joinville de Joinville de Joinville de Joinville de Joinville dew",
            "state" to "SCS",
            "country" to "BRS",
            "documentType" to 6,
            "document" to "014M51373000134",
            "phoneCountryCode" to 10930492,
            "phoneNumber" to "9375E01326",
            "bankBranchCheckDigit" to 18,
            "bankAccountType" to 3,
            "bankAccountCheckDigit" to "18ç",
            "bankAccountNumber" to 3487354598211,
            "bankBranchNumber" to "00000",
            "bankCode" to "394283"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/merchant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(merchant).toString())
        )
            .andExpect(status().isBadRequest)
    }

    @Test
    @Throws(Exception::class)
    fun addEmptyBodyTest() {

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/merchant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        )
            .andExpect(status().isBadRequest)
            .andDo(print())
    }
}