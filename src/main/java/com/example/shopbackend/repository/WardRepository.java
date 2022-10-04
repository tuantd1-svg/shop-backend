package com.example.shopbackend.repository;

import com.example.shopbackend.repository.dto.province.Ward;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WardRepository extends MongoRepository<Ward,Long> {
    List<Ward> findAllByDistrictCode(int districtCode);
}
