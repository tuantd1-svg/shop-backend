package com.example.shopbackend.repository.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@Document("CartItem")
public class CartItem {
    @Transient
    public static final String SEQUENCE_NAME = "cartItem_sequence";
    @Id
    private Long id;
    private Long idProducts;
    private Long idCart;
    private BigDecimal amount;
    private int numberProductOrder;
    private int active; //0C chua dat hang 1 dat hang 2 dat hang roi nhung chua xac nhan ,3 dat hang da xac nhan ,4 giao ben van chuyen

}
