package com.example.shopbackend.repository.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document("Carts")
public class Cart {
  @Transient
  public static final String SEQUENCE_NAME = "Carts_sequence";
  @Id
  private Long id;
  private String cartName;
  private Long idCartItem;
  private Long idUser;
  private String session;
}
