package com.example.shopbackend.repository.dto;

import com.example.commonapi.model.AbstractTimestampEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("ProductAttributes")
public class ProductAttributes extends AbstractTimestampEntity {
    private Long idProduct;
    @Transient
    public static final String SEQUENCE_NAME = "ProductAttributes_sequence";
    @Id
    private Long id;
    private List<Integer> size;
    private List<String> color;
    private List<String> imageProducts;

}
