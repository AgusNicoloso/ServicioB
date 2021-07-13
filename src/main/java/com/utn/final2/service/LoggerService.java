package com.utn.final2.service;

import com.utn.final2.models.Logger;
import com.utn.final2.models.TicketDTO;
import com.utn.final2.repository.LoggerRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

  @Autowired
  private LoggerRepository loggerRepository;
  @Autowired
  private TicketClient ticketClient;

  public Logger createLog(UUID ticketNumber, Logger logger) {
    TicketDTO ticketDTO = ticketClient.getTicketByTicketNumber(ticketNumber);
    logger.setDate(LocalDateTime.now());
    logger.setDiscount(ticketDTO.getDiscount());
    logger.setTicketNumber(ticketDTO.getTicketNumber());
    return loggerRepository.save(logger);

  }
}
