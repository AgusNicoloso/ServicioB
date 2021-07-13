package com.utn.final2.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Data;

@Data
public class TicketDTO {

  @JsonProperty("ticketNumber")
  private UUID ticketNumber;
  @JsonProperty("discount")
  private Integer discount;
}
