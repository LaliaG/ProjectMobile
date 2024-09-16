package com.example.gatewayservice.dto.StockDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoRequest {
    private int iduser;
    private int idcarRide;
}
