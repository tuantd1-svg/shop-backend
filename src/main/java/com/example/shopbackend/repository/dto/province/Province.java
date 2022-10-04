package com.example.shopbackend.repository.dto.province;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
@Data
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int code;
    private String divisionType;
    private String codeName;
    private int phoneCode;



}



