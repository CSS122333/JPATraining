package com.antra.ecommerce.jpatraining.repository;

import com.antra.ecommerce.jpatraining.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
