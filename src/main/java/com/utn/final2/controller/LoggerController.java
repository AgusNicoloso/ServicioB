package com.utn.final2.controller;

import com.utn.final2.models.Logger;
import com.utn.final2.service.LoggerService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loggers")
public class LoggerController {

  @Autowired
  private LoggerService loggerService;

  @PostMapping("/{ticketNumber}")
  public ResponseEntity<Logger> generateLog(@PathVariable("ticketNumber") UUID ticketNumber) {
    return ResponseEntity.ok(loggerService.createLog(ticketNumber, new Logger()));
  }
}
