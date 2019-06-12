package com.routinecart.repository;

import org.springframework.data.repository.CrudRepository;

import com.routinecart.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
