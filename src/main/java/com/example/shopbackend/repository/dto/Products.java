package com.example.shopbackend.repository.dto;

import com.example.commonapi.model.AbstractTimestampEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("products")
public class Products extends AbstractTimestampEntity {
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";
    @Id
    private Long id;
    private String title;
    private double price;
    private String description;
    private Boolean active;//con hang hay la het hang
    private int inventory;
    private Long idCategory;
    private Double rate;
    private String createUser;
    private String updateUser;

}
