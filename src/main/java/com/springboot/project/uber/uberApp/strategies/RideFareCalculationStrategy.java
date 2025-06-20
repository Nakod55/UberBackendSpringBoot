package com.springboot.project.uber.uberApp.strategies;

import com.springboot.project.uber.uberApp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDto rideRequestDto);
}
