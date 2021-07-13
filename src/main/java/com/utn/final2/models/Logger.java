package com.utn.final2.models;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Logger {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private UUID ticketNumber;
  private Integer discount;
  private LocalDateTime date;
}
