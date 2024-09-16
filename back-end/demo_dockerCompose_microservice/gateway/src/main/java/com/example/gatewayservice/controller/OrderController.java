package com.example.gatewayservice.controller;

import com.example.gatewayservice.dto.OrderDto.CarRideDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class OrderController {

    @GetMapping("")
    public ResponseEntity<List<OrderDtoResponse>> getAllDelivery (){
        System.out.println("api gateway");
        RestClient<OrderDtoResponse[]> deliveryRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride");
        List<OrderDtoResponse> orderDtoResponses = Arrays.stream(orderRestCLient.getRequest(CarRideDtoResponse[].class)).toList();
        return new ResponseEntity<>(orderDtoResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDtoResponse> getOderById (@PathVariable int id){
        RestClient<OrderDtoResponse> orderRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/"+id);
        OrderDtoResponse orderDtoResponse = orderRestCLient.getRequest(OrderDtoResponse.class);
        return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/car_ride_without/{idUser}")
    public ResponseEntity<List<CarRideDtoResponse>> getAllCarRideWithoutUser (@PathVariable int idUser){
        RestClient<CarRideDtoResponse[]> carRideRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/car_ride_without/"+idUser);
        List<CarRideDtoResponse> carRideDtoResponses = Arrays.stream(carRideRestCLient.getRequest(CarRideDtoResponse[].class)).toList();
        return new ResponseEntity<>(carRideDtoResponses,HttpStatus.OK);
    }

    @GetMapping("/car_ride/{idUser}")
    public ResponseEntity<List<CarRideDtoResponse>> getAllCarRideByUserId (@PathVariable int idUser){
        RestClient<CarRideDtoResponse[]> carRideRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/car_ride/"+idUser);
        List<CarRideDtoResponse> carRideDtoResponses = Arrays.stream(carRideRestCLient.getRequest(CarRideDtoResponse[].class)).toList();
        return new ResponseEntity<>(carRideDtoResponses,HttpStatus.OK);
    }
}
