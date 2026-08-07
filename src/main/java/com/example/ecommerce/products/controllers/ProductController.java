package com.example.ecommerce.products.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerce.products.entities.Product;
import com.example.ecommerce.products.requests.ProductRequest;
import com.example.ecommerce.products.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public Page<Product> index(@RequestParam(defaultValue = "0") int page) {
        return productService.list(page);
    }

    @PostMapping("/product/store")
    public Product store(@Valid @RequestBody ProductRequest request) {
        return productService.store(request);
    }

    @PutMapping("/product/{id}/update")
    public Product update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        return productService.update(id, request);
    }

    @DeleteMapping("/product/{id}/delete")
    public boolean delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}
