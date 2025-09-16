package com.mtd.ecomapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mtd.ecomapp.entity.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
