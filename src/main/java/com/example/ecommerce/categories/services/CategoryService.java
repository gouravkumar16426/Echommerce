package com.example.ecommerce.categories.services;

import java.util.List;

import com.example.ecommerce.categories.responses.CategoryResponse;
import org.springframework.stereotype.Service;

import com.example.ecommerce.categories.entities.Category;
import com.example.ecommerce.categories.repositories.CategoryRepository;
import com.example.ecommerce.categories.requests.CategoryRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService{
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> list(){
        List<CategoryResponse> categories = categoryRepository.findAllOrderByName();
        return categories; 
    }

    public Category create(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    public Category update(Long id, CategoryRequest request){
        Category category = categoryRepository.findById(id)
                                              .orElseThrow(()-> new RuntimeException("Category not found"));
        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    public Category delete(Long id){
        Category category = categoryRepository.findById(id)
                                              .orElseThrow(()-> new RuntimeException("Category not found"));
        categoryRepository.deleteById(id);
        return category;
    }
}