package com.example.shopbackend.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardInfo {
    private Long idProduct;
    private String session;
    private BigDecimal amount;
    private Integer size;
    private String color;
    private int total;
    private Long idUser;
}
