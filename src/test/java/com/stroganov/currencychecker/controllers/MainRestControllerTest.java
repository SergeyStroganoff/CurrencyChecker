package com.stroganov.currencychecker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stroganov.currencychecker.models.OriginalGiphy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class MainRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void WhenGetExchangeRate_ThenReturnOK() throws Exception {
        //GIVEN
        String endPointURL = "/exchange-rates/dynamics/fast-result";
        //WHEN
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(endPointURL));
        //THEN
        String response = resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        OriginalGiphy originalGiphy = objectMapper.readValue(response, OriginalGiphy.class);
        Assertions.assertTrue(originalGiphy.getLink().startsWith("https"));
    }
}