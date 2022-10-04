package com.example.shopbackend.repository.dto;

import com.example.commonapi.model.AbstractTimestampEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("Orders")
@Data
public class Orders extends AbstractTimestampEntity {
    @Id
    private Long id;
    private Long cartId;
    private Long idUser;
    private Boolean payment;
    private String shippingAddress;
    private String orderDescription;
    private int orderTotal;
    private Boolean isComplete;//false,true
    private String status;//0 Chua xac nhan --1 da xac nhan --2 Dang van chuyen --3 Da xong
    private String statusDescription;//co the null content yeu cau cua KH

}
