package com.antra.ecommerce.jpatraining.repository;

import com.antra.ecommerce.jpatraining.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findByEmail(String email);
}

// JDBC          -   SQL, connection, statement, result set
// JPA/hibernate -   JPQL, session manager, entity manager
// Spring Data JPA - Repository interfaces, query methods,
