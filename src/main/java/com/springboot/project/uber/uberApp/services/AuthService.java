package com.springboot.project.uber.uberApp.services;

import com.springboot.project.uber.uberApp.dto.DriverDto;
import com.springboot.project.uber.uberApp.dto.SignUpDto;
import com.springboot.project.uber.uberApp.dto.UserDto;
import com.springboot.project.uber.uberApp.entities.Driver;

public interface AuthService {
    String login(String email, String password);
    UserDto signUp(SignUpDto signUpDto);
    DriverDto onBoardNewDriver(Long userId);
}
