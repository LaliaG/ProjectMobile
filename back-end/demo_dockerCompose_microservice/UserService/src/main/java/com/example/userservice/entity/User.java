package com.example.userservice.entity;

import com.example.userservice.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "encrypted", nullable = false)
    private String password ;
    private Role role;
}
