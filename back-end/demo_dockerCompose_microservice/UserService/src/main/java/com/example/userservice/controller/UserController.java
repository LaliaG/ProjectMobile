package com.example.userservice.controller;

import com.example.userservice.dto.UserDtoRequest;
import com.example.userservice.dto.UserDtoResponse;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> findById (@PathVariable int id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/findbyemail")
    public ResponseEntity<UserDtoResponse> findByEmail (@RequestBody UserDtoRequest userDtoRequest){
        return new ResponseEntity<>(userService.findByEmail(userDtoRequest.getEmail()),HttpStatus.OK);
    }
}
