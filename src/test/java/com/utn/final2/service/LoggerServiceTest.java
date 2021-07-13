package com.utn.final2.service;

import static org.mockito.Mockito.when;

import com.utn.final2.models.Logger;
import com.utn.final2.models.TicketDTO;
import com.utn.final2.repository.LoggerRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerServiceTest {

  @Mock
  private LoggerRepository loggerRepository;
  @Mock
  private TicketClient ticketClient;
  @InjectMocks
  private LoggerService loggerService;

  private Logger logger;

  private TicketDTO ticketDTO;

  @BeforeEach
  void setUp() {
    logger = new Logger();
    ticketDTO = new TicketDTO();
    UUID uuid = UUID.randomUUID();
    ticketDTO.setTicketNumber(uuid);
    ticketDTO.setDiscount(80);
    logger.setDate(LocalDateTime.now());
    logger.setDiscount(80);
    logger.setTicketNumber(uuid);
  }

  @Test
  void createLog() {
    when(ticketClient.getTicketByTicketNumber(logger.getTicketNumber())).thenReturn(ticketDTO);
    when(loggerRepository.save(logger)).thenReturn(logger);

    Logger expectedLogger = loggerService.createLog(ticketDTO.getTicketNumber(), logger);

    Assertions.assertEquals(expectedLogger.getTicketNumber(), ticketDTO.getTicketNumber());
    Assertions.assertEquals(expectedLogger.getDiscount(), ticketDTO.getDiscount());
    Assertions.assertEquals(expectedLogger.getDate(), logger.getDate());

  }

}
