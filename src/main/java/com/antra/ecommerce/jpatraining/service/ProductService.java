package com.antra.ecommerce.jpatraining.service;

import com.antra.ecommerce.jpatraining.entity.Product;
import com.antra.ecommerce.jpatraining.repository.OrderRepo;
import com.antra.ecommerce.jpatraining.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductRepo productRepo;

    @Transactional
    public void creatProducts() {
        var orange = new Product();
        orange.setName("Orange");
        orange.setPrice(100.11);
        productRepo.save(orange);
    }

    public void updateOrder() {
        // update order
        var p = new Product() ;
        p.setId(9);
        p.setPrice(500.11);
        productRepo.save(p);
    }

    public void deleteOrder() {
        // delete order
    }

    public void getOrder() {
        // get order
    }
}
