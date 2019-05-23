package com.gateway.pagamentos.gatewaypagamentos.controller

import com.gateway.pagamentos.gateway.entity.CreditCard
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(CreditCard::class)
internal class CreditCardControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Throws(Exception::class)
    @Test
    fun testGetOne(){
        mockMvc.perform(get("/credit_card/1"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}