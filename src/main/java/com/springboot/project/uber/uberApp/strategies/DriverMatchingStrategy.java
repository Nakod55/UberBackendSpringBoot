package com.springboot.project.uber.uberApp.strategies;

import com.springboot.project.uber.uberApp.dto.RideRequestDto;
import com.springboot.project.uber.uberApp.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
