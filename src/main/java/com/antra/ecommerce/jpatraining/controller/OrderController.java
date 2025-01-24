package com.antra.ecommerce.jpatraining.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @GetMapping // ALL ORDERS: Pagination
    public void getOrder() {
    }

    @GetMapping("/{id}") // GET ORDER BY ID
    public void getOrderById() {

    }

    @PutMapping// CREATE ORDER
    public void createOrder() {

    }

    @PostMapping // UPDATE ORDER
    public void updateOrder() {

    }

    @DeleteMapping("/{id}") // DELETE ORDER BY ID
    public void deleteOrder() {

    }
    // Validation
    // Exception Handling
    // Logging
    // Security
    // Data response/status code
}


// RESTful API
// HTTP protocol
// HTTP Sync

// HTTP REQUEST/RESPONSE
// GET POST PUT DELETE PATCH OPTIONS
// HTTP body

// HTTP STATUS CODE 200 201 204 400 401 403 404 500

// HTTP HEADER


// Order  RESTful API
// GET  /order       get all orders
// GET  /order/{id}  get order by id
// GET  /order?customerId=123  get order by customer id
// GET  /order?status=PAID  get order by status

// POST /order      create order
//{new order info}

// PUT  /order    update order
//{updated order info}
// PATCH  /order  Partial update order
//{updated order fields}

// DELETE /order/{id} delete order by id


// Resource based
// Stateless
