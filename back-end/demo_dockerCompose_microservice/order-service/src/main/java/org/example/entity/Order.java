package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.ClientDto;
import org.example.dto.ProductDto;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;

    @Temporal(TemporalType.DATE)
    private LocalDateTime orderDate;
    @Column(name= "product_id")
    private Long productId;
    @Column(name= "client_id")
    private Long clientId;

    @Transient
    public ProductDto productDto;

    @Transient
    public ClientDto clientDto;







}


