package com.utn.final2.service;

import com.utn.final2.models.TicketDTO;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticket", url = "localhost:9000/tickets")
public interface TicketClient {

  @GetMapping(path = "/{ticketNumber}")
  TicketDTO getTicketByTicketNumber(@PathVariable("ticketNumber") UUID ticketNumber);
}
