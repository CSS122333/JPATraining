package com.antra.ecommerce.jpatraining.service;

import com.antra.ecommerce.jpatraining.api.request.ProductVO;
import com.antra.ecommerce.jpatraining.entity.Customer;
import com.antra.ecommerce.jpatraining.entity.Order;
import com.antra.ecommerce.jpatraining.entity.Product;
import com.antra.ecommerce.jpatraining.repository.OrderRepo;
import com.antra.ecommerce.jpatraining.repository.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

@Service
@Transactional
public class ProductService{

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    RedisTemplate redisTemplate;

    @Transactional
    public ProductVO creatProduct(ProductVO productVO) {
        // check if name exists


        Product product = new Product();
        BeanUtils.copyProperties(productVO, product);

        var savedProduct = productRepo.save(product);
        BeanUtils.copyProperties(savedProduct, productVO);
        return productVO;
    }

    public void updateOrder(Customer custoer, Order order) {
        // update order
        var p = new Product() ;
        p.setId(9);
        p.setPrice(500.11);
        productRepo.save(p);
    }

    public Product getProduct(Integer id) { // 1.2.3.4
        Product p = (Product) redisTemplate.opsForValue().get("product:" + id); // product:1
        if (p == null) {
            p = productRepo.findById(id).get();
            redisTemplate.opsForValue().set("product:" + id, p, Duration.ofSeconds(10));
        }
        return p;
    }

    public void updateProduct(Product product) {
        productRepo.save(product);
        redisTemplate.opsForValue().set("product:" + product.getId(), product, Duration.ofSeconds(10));
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getAllProducts(int page, int size) {
        return productRepo.findAll(Pageable.ofSize(size).withPage(page - 1)).stream().toList();
    }
}
