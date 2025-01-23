show databases;

-- create database called ecommerce
Create DATABASE IF NOT EXISTS `e-commerce`;

use `e-commerce`;

-- create a table named customer with basic fields

CREATE TABLE IF NOT EXISTS `customer` (
                                          `id` int(11) NOT NULL AUTO_INCREMENT,
                                          `first_name` varchar(50) DEFAULT NULL,
                                          `last_name` varchar(50) DEFAULT NULL,
                                          `email` varchar(50) DEFAULT NULL,
                                          `phone` varchar(20) DEFAULT NULL,
                                          PRIMARY KEY (`id`)
)  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- create 'product' table with basic fields

CREATE TABLE IF NOT EXISTS `product` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT,
                                         `name` varchar(100) DEFAULT NULL,
                                         `description` text,
                                         `price` decimal(10,2) DEFAULT NULL,
                                         PRIMARY KEY (`id`)
)  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- create order table with basic fields with foreign key to customer table
CREATE TABLE IF NOT EXISTS `order` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT,
                                       `customer_id` int(11) DEFAULT NULL,
                                       `order_date` datetime DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       FOREIGN KEY (`customer_id`) REFERENCES `customer`(`id`)
)  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- create order_items table with basic fields with foreign key to orders table and product table
CREATE TABLE IF NOT EXISTS `order_items` (
                                             `id` int(11) NOT NULL AUTO_INCREMENT,
                                             `order_id` int(11) DEFAULT NULL,
                                             `product_id` int(11) DEFAULT NULL,
                                             `quantity` int(11) DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             FOREIGN KEY (`order_id`) REFERENCES `order`(`id`),
                                             FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
)  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
