package com.antra.ecommerce.jpatraining.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "invoice")
public class Invoice {
    @Id
    private String id;
    @JsonProperty("customerAAA")
    private String customerId;
    private List<String> productList;
    private BigDecimal totalPrice;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", productList=" + productList +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
