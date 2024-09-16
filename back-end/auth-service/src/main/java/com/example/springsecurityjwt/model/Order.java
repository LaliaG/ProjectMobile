package com.example.springsecurityjwt.model;

import com.example.springsecurityjwt.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;
    private Status status;


    @ManyToOne (cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
