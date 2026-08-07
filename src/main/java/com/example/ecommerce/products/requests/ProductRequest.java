package com.example.ecommerce.products.requests;

import com.example.ecommerce.categories.entities.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequest{
    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50)
    private String name;

    private String description;

    private boolean isActive;

    private int quantity;

    private float price;

    @NotNull(message = "Category is required.")
    private Long categoryId;
}