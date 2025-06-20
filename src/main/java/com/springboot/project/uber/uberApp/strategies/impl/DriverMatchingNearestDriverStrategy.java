package com.springboot.project.uber.uberApp.strategies.impl;

import com.springboot.project.uber.uberApp.dto.RideRequestDto;
import com.springboot.project.uber.uberApp.entities.Driver;
import com.springboot.project.uber.uberApp.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
