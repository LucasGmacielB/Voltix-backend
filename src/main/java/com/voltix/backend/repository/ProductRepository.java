package com.voltix.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.voltix.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
