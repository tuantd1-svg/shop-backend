package com.example.shopbackend.repository.dto.province;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Data
@Document(value = "city")
public class City extends Province implements Serializable {
    private static final long serialVersionUID = 1L;
    @MongoId
    private Long id;



}
