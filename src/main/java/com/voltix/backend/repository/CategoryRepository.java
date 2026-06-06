package com.voltix.backend.repository;

import com.voltix.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    boolean existsByName(String name);
}