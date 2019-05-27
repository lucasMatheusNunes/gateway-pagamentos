package com.gateway.pagamentos.gatewaypagamentos.controller

import com.gateway.pagamentos.gateway.controller.PaymentReversalController
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.bind.annotation.*

@RunWith(SpringRunner::class)
class PaymentReversalCTest {

    private var mockMvc: MockMvc? = null

    @Autowired
    private val prc: PaymentReversalController? = PaymentReversalController()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(prc).build();
    }

    // TESTS
    // FIND ALL
    @Test
    @Throws(Exception::class)
    fun findAllRevPayTest() {
        this.mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/payment-reversal")
                .header("token", "sgsdgdfgsfvsdfv")
        )
            .andExpect(status().is2xxSuccessful())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    // FIND ONE
    @Test
    @Throws(Exception::class)
    fun findOneRevPayTest() {
        this.mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/payment-reversal/1")
                .header("token", "sgsdgdfgsfvsdfv")
        )
            .andExpect(status().isOk)
            .andExpect(
                content().contentType(MediaType.APPLICATION_JSON_UTF8)
            )
    }

    // ADD - SUCCESS
    @Test
    @Throws(Exception::class)
    fun addCreditSuccess() {
        val paymentReversal = mapOf(
            "idMerchant" to 1,
            "idTransaction" to 1,
            "amount" to 199
        )
        this.mockMvc!!.perform(
            MockMvcRequestBuilders
                .post("/payment-reversal")
                .header("token", "sgsdgdfgsfvsdfv")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(paymentReversal).toString())
        )
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", IsNot.not(0)))
    }

    // ADD - ERROR
    @Test
    @Throws(Exception::class)
    fun addPaymentReversalError() {
        val paymentReversal = mapOf(
            "idMerchant" to "hgfhgf",
            "idTransaction" to 1,
            "amount" to 199
        );
        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/payment-reversal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(paymentReversal).toString())
        )
            .andExpect(status().is4xxClientError())
        println("Payment-reversal tests completed")
    }

}
