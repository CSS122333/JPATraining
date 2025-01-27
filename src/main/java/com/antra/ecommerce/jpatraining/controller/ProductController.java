package com.antra.ecommerce.jpatraining.controller;

import com.antra.ecommerce.jpatraining.api.request.ProductVO;
import com.antra.ecommerce.jpatraining.entity.Product;
import com.antra.ecommerce.jpatraining.exception.ProductErrorResponse;
import com.antra.ecommerce.jpatraining.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductVO>> getProduct(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "3") int size) {

        var products = productService.getAllProducts(page, size).stream().map(p -> {
            ProductVO vo = new ProductVO();
            BeanUtils.copyProperties(p, vo);
            return vo;
        }).toList();

//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add("company", "Antra");
//        var res = new ResponseEntity<>(products, headers, HttpStatus.OK);
//        return res;

        if(products.isEmpty()) {
            throw new RuntimeException("No product found");
        }

        return ResponseEntity.ok(products);
    }
    // GET /product pagination
    // GET /product/{id}   find by id
    // GET /product?name=apple  find by name

    @PostMapping
    public ResponseEntity<ProductVO> createProduct(@Validated @RequestBody ProductVO productVO) {
        ProductVO p = productService.creatProduct(productVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productVO);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ProductErrorResponse> handleException(RuntimeException e) {
        var response = new ProductErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ProductErrorResponse> handleException(MethodArgumentNotValidException e) {
        var response = new ProductErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(Exception e) {
        var response = new ProductErrorResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(e.getCause().getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }



}
