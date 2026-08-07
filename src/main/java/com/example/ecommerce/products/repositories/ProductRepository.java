package com.example.ecommerce.products.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.products.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}