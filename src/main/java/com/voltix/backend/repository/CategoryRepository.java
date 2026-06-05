package com.voltix.backend.repository;

import com.voltix.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID>{
    boolean existsByName(String name);
}