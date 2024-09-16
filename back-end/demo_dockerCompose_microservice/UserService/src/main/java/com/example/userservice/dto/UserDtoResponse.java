package com.example.userservice.dto;

import com.example.userservice.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {
    private int id_user;
    private String username;
    private String email;
    private String password;
    private int role;
}
