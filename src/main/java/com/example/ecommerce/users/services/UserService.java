package com.example.ecommerce.users.services;

import com.example.ecommerce.users.requests.RegisterRequest;
import com.example.ecommerce.users.responses.UserResponse;

public interface UserService {
    UserResponse register(RegisterRequest request);
}
