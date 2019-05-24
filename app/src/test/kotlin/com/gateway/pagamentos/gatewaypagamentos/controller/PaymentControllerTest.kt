package com.gateway.pagamentos.gatewaypagamentos.controller

import com.gateway.pagamentos.gateway.controller.PaymentController
import org.hamcrest.core.IsNot
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
class PaymentControllerTest {

    private var mockMvc: MockMvc? = null

    @Autowired
    private val paymentController: PaymentController? = PaymentController()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build()
    }

    @Test
    @Throws(Exception::class)
    fun addCreditSuccess() {
        val payment = mapOf(
            "paymentMethod" to "credit_card",
            "creditCardId" to 1,
            "merchantId" to 1,
            "clientId" to 1,
            "amount" to 199,
            "metadata" to "coffe",
            "installments" to 1
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(payment).toString())
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", IsNot.not(0)))
    }

    @Test
    @Throws(Exception::class)
    fun addCreditEmpty() {
        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }
}