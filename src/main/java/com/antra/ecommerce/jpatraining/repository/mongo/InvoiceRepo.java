package com.antra.ecommerce.jpatraining.repository.mongo;

import com.antra.ecommerce.jpatraining.document.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepo extends MongoRepository<Invoice, String> {
    Invoice findByCustomerId(String customerId);
}
