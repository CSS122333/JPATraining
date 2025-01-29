package com.antra.ecommerce.jpatraining.api.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class ProductVO {
    private Integer id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private String description;
    private Double price;

    public ProductVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}



// VO
// POJO
// DTO
// BO
