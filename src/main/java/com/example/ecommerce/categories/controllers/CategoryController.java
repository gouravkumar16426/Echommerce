package com.example.ecommerce.categories.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.categories.entities.Category;
import com.example.ecommerce.categories.requests.CategoryRequest;
import com.example.ecommerce.categories.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController{
    private final CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> index(){
        return ResponseEntity.ok()
                .body(
                        Map.of(
                                "status", true,
                                "message", "Categories Fetched Successfully",
                                "data", categoryService.list()
                        )
                );
    }

    @PostMapping("/category/store")
    public ResponseEntity<?> store(@Valid @RequestBody CategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
//                .header("version", "1.0")
                .body(
                        Map.of(
                                "status", true,
                                "message", "Category Created",
                                "data", categoryService.create(request)
                        )
                );
    }

    @PutMapping("/category/{id}/update")
    public Category update(@PathVariable Long id, @Valid @RequestBody CategoryRequest request){
        return categoryService.update(id, request);
    }

    @DeleteMapping("category/{id}/delete")
    public Category delete(@PathVariable Long id){
        return categoryService.delete(id);
    }
}