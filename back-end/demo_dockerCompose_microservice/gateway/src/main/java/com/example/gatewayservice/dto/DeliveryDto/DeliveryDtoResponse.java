package com.example.gatewayservice.dto.DeliveryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDtoResponse {
    private String idComment;
    private int idUser;
    private int idCarRide;
    private int idDriver;
    private  float note;
    private String comment;
    private LocalDate date;
}
