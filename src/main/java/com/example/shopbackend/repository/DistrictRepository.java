package com.example.shopbackend.repository;

import com.example.shopbackend.repository.dto.province.Districts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DistrictRepository extends MongoRepository<Districts,Long> {
    List<Districts> findAllByProvinceCode(int provinceCode);
}
