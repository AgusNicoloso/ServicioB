package com.utn.final2.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.utn.final2.service.LoggerService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(LoggerController.class)
class LoggerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private LoggerService loggerService;

  private UUID uuid;

  @BeforeEach
  void setUp() {
    uuid = UUID.randomUUID();
  }

  @Test
  void createLogger() throws Exception {
    ResultActions resultActions = mockMvc
        .perform(MockMvcRequestBuilders.
            post("/loggers/" + uuid))
        .andExpect(status().isOk());

  }

}
