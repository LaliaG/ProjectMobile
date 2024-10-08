package com.example.gatewayservice.dto.AuthDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDtoRequest {
    private String email;
    private String lastname;
    private String firstname;
    private String password;
    private int role;
}
