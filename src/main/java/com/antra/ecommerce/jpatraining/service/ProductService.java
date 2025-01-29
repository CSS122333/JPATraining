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

    public ProductVO getProduct(Integer id) { // 1.2.3.4
        ProductVO p = (ProductVO) redisTemplate.opsForValue().get("product:" + id); // product:1
        if (p == null) {
            var product = productRepo.findById(id).get();
            p = new ProductVO();
            BeanUtils.copyProperties(product, p);
            redisTemplate.opsForValue().set("product:" + id, p, Duration.ofSeconds(120));
        }
        return p;
    }

    public ProductVO updateProduct(ProductVO productvo) {
        Product product = new Product();
        BeanUtils.copyProperties(productvo, product);
        productRepo.save(product);
        redisTemplate.opsForValue().set("product:" + product.getId(), product, Duration.ofSeconds(120));
        return productvo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getAllProducts(int page, int size) {
        return productRepo.findAll(Pageable.ofSize(size).withPage(page - 1)).stream().toList();
    }

    public ProductVO deleteProduct(Integer id) {
        var p = this.getProduct(id);
        productRepo.deleteById(id);
        return p;
    }
}
