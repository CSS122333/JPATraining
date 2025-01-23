package com.antra.ecommerce.jpatraining;

import com.antra.ecommerce.jpatraining.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestProductService {

    @Autowired
    ProductService productService;

    @Test
    void testCreateProducts() {
        productService.creatProducts();
    }

    @Test
    void testUpdate() {
        productService.updateOrder();
    }
}
