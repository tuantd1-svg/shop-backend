package com.example.shopbackend.repository.dto.province;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Document("wards")
public class Ward extends Province implements Serializable {
    private static final long serialVersionUID = 1L;

    @MongoId
    private Long id;
    private String shortCodeName;


    private int districtCode;

}
