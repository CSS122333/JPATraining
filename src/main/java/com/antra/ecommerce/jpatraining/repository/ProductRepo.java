package com.antra.ecommerce.jpatraining.repository;

import com.antra.ecommerce.jpatraining.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
