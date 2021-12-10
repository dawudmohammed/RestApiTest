package com.khoders.RestApiTesting.repository;

import com.khoders.RestApiTesting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
