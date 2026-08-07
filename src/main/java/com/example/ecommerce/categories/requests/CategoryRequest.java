package com.example.ecommerce.categories.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest{
    @NotBlank(message="Name is Required")
    @Size(min=3,max=100)
    private String name;
}