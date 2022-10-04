package com.example.shopbackend.repository.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("variation")
public class Variation {
    @Transient
    public static final String SEQUENCE_NAME = "Variation_sequence";
    @Id
    private Long id;
    private Long idProduct;
    private String title;
    private int discount;
    private Boolean active;

}
