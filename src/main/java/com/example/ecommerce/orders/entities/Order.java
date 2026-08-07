package com.example.ecommerce.orders.entities;

import com.example.ecommerce.products.entities.Product;
import com.example.ecommerce.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double amount;

    private String status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
}
