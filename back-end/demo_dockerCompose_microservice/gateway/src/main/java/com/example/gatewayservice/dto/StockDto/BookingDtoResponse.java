package com.example.gatewayservice.dto.StockDto;

import com.example.gatewayservice.dto.OrderDto.CarRideDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoResponse {
    private int id_Booking;
    private int iduser;
    private CarRideDtoResponse carRide;
}
