package com.example.shopbackend.repository.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("categories")
public class Categories {

    @Transient
    public static final String SEQUENCE_NAME = "categories_sequence";
    @Id
    private Long id;
    private String name;
    private String title;
    private Boolean active;
    private Long createAt;
    private Long modifiedAt;
    private String createUser;
    private String updateUser;
}

