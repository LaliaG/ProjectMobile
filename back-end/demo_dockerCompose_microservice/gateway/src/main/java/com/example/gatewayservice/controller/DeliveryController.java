package com.example.gatewayservice.controller;

import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/delivery")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class DeliveryController {

    @GetMapping("")
    public ResponseEntity<List<DeliveryDtoResponse>> getAllDeliveries (){
        RestClient<DeliveryDtoResponse[]> deliveryRestCLient = new RestClient<>("http://localhost:"+ PortApi.portDelivery +"/api/delivery");
        List<DeliveryDtoResponse> deliveryDtoResponses = Arrays.stream(deliveryRestCLient.getRequest(DeliveryDtoResponse[].class)).toList();
        return new ResponseEntity<>(deliveryDtoResponses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDtoResponse> getDeliveryById (@PathVariable String id){
        RestClient<DeliveryDtoResponse> deliveryRestCLient = new RestClient<>("http://localhost:"+ PortApi.portDelivery +"/api/delivery/"+id);
        DeliveryDtoResponse deliveryDtoResponse = deliveryRestCLient.getRequest(DeliveryDtoResponse.class);
        return new ResponseEntity<>(deliveryDtoResponse, HttpStatus.OK);
    }
}
