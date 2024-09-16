package com.example.userservice.service.impl;

import com.example.userservice.Exception.NotFoundException;
import com.example.userservice.dto.UserDtoResponse;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDtoResponse findById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return new UserDtoResponse(user.getId_user(),user.getUsername(),user.getEmail(),user.getPassword(),user.getRole().ordinal());
        }
        throw new NotFoundException();
    }

    @Override
    public UserDtoResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null){
            return new UserDtoResponse(user.getId_user(),user.getUsername(),user.getEmail(),  ((User) user).getPassword(), user.getRole().ordinal());
        }
        return null;
    }
}
