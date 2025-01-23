package com.antra.ecommerce.jpatraining;

import com.antra.ecommerce.jpatraining.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaTrainingApplication.class, args);
    }
}
