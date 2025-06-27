package com.springboot.project.uber.uberApp.services.impl;

import com.springboot.project.uber.uberApp.dto.DriverDto;
import com.springboot.project.uber.uberApp.dto.SignUpDto;
import com.springboot.project.uber.uberApp.dto.UserDto;
import com.springboot.project.uber.uberApp.entities.Driver;
import com.springboot.project.uber.uberApp.entities.User;
import com.springboot.project.uber.uberApp.entities.enums.Role;
import com.springboot.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.springboot.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.springboot.project.uber.uberApp.repositories.UserRepository;
import com.springboot.project.uber.uberApp.repositories.WalletRepository;
import com.springboot.project.uber.uberApp.services.AuthService;
import com.springboot.project.uber.uberApp.services.DriverService;
import com.springboot.project.uber.uberApp.services.RiderService;
import com.springboot.project.uber.uberApp.services.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.springboot.project.uber.uberApp.entities.enums.Role.DRIVER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
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
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId, String vehicleId) {
        User user= userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id "+userId));
        if(user.getRoles().contains(DRIVER)){
            throw new RuntimeConflictException("User with id "+userId+" is already a Driver");
        }
        Driver createNewDriver= Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(DRIVER);
        userRepository.save(user);
        Driver savedDriver= driverService.createNewDriver(createNewDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }
}
