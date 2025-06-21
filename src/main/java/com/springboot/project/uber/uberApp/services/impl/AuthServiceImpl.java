package com.springboot.project.uber.uberApp.services.impl;

import com.springboot.project.uber.uberApp.dto.DriverDto;
import com.springboot.project.uber.uberApp.dto.SignUpDto;
import com.springboot.project.uber.uberApp.dto.UserDto;
import com.springboot.project.uber.uberApp.entities.Rider;
import com.springboot.project.uber.uberApp.entities.User;
import com.springboot.project.uber.uberApp.entities.enums.Role;
import com.springboot.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.springboot.project.uber.uberApp.repositories.UserRepository;
import com.springboot.project.uber.uberApp.services.AuthService;
import com.springboot.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signUp(SignUpDto signUpDto) {

        User user=userRepository.findByEmail(signUpDto.getEmail()).orElse(null);
        if(user!=null){
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signUpDto.getEmail());
        }
        User mappedUser= modelMapper.map(signUpDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser= userRepository.save(mappedUser);

        //creating user related entities
        riderService.createNewRider(savedUser);


        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
