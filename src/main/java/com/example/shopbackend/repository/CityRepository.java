package com.example.shopbackend.repository;

import com.example.shopbackend.repository.dto.province.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City,Long> {
}
