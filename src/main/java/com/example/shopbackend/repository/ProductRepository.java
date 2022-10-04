package com.example.shopbackend.repository;

import com.example.shopbackend.repository.dto.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products,Long> {
}
