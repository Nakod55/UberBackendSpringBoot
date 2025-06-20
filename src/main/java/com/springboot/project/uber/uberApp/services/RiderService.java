package com.springboot.project.uber.uberApp.services;

import com.springboot.project.uber.uberApp.dto.DriverDto;
import com.springboot.project.uber.uberApp.dto.RideDto;
import com.springboot.project.uber.uberApp.dto.RideRequestDto;
import com.springboot.project.uber.uberApp.dto.RiderDto;
import com.springboot.project.uber.uberApp.entities.enums.RideRequestStatus;

import java.util.List;

public interface RiderService {

        RideRequestDto requestRide(RideRequestDto rideRequestDto);
        RideDto cancelRide(Long rideId);
        DriverDto rateDriver(Long rideId, Integer rating);
        RiderDto getMyProfile();
        List<RiderDto> getAllMyRides();
}
