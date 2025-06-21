package com.springboot.project.uber.uberApp.services;

import com.springboot.project.uber.uberApp.dto.DriverDto;
import com.springboot.project.uber.uberApp.dto.SignUpDto;
import com.springboot.project.uber.uberApp.dto.UserDto;

public interface AuthService {
    String login(String email, String password);
    UserDto signUp(SignUpDto signUpDto);
    DriverDto onBoardNewDriver(Long userId);
}
