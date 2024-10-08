package com.example.gatewayservice.dto.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRideDtoRequest {
    private int id_user_driver;
    private String start_point;
    private String end_point;
    private int seatMax;
    private String startDateStr;
    private float price;
}
