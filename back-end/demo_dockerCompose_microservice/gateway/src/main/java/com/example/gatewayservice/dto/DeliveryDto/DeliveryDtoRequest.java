package com.example.gatewayservice.dto.DeliveryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDtoRequest {
    private int idUser;
    private int idCarRide;
    private int idDriver;
    private  float note;
    private String comment;
    private String date;
}
