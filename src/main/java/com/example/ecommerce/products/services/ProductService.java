package com.example.ecommerce.products.services;

import java.util.List;

import com.example.ecommerce.categories.entities.Category;
import com.example.ecommerce.categories.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ecommerce.products.entities.Product;
import com.example.ecommerce.products.repositories.ProductRepository;
import com.example.ecommerce.products.requests.ProductRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Page<Product> list(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> products = productRepository.findAll(pageable);
        return products;
    }

    public Product store(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found."));
//        Product product = new Product();

//        product.setName(request.getName());
//        product.setDescription(request.getDescription());
//        product.setActive(request.isActive());
//        product.setQuantity(request.getQuantity());
//        product.setPrice(request.getPrice());
//
//        product.setCategoryId(request.getCategoryId());

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .isActive(request.isActive())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .category(category)
                .build();

        return productRepository.save(product);
    }

    public Product update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Category not found."));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setActive(request.isActive());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
//        product.setCategoryId(request.getCategoryId());
        product.setCategory(category);

        return productRepository.save(product);
    }

    public boolean delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);
//        productRepository.deleteById(id);
        return true;

    }
}