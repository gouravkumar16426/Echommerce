package com.example.ecommerce.categories.repositories;

import com.example.ecommerce.categories.responses.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.categories.entities.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("""
            SELECT new com.example.ecommerce.categories.responses.CategoryResponse(
            id, name
            )
            FROM Category ORDER BY name ASC
            """)
    List<CategoryResponse> findAllOrderByName();

}