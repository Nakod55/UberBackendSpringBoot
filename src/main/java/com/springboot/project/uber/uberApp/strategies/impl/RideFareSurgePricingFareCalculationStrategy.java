package com.springboot.project.uber.uberApp.strategies.impl;

import com.springboot.project.uber.uberApp.dto.RideRequestDto;
import com.springboot.project.uber.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
