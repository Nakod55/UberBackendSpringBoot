package com.springboot.project.uber.uberApp.services.impl;

import com.springboot.project.uber.uberApp.dto.DriverDto;
import com.springboot.project.uber.uberApp.dto.RideDto;
import com.springboot.project.uber.uberApp.dto.RideRequestDto;
import com.springboot.project.uber.uberApp.dto.RiderDto;
import com.springboot.project.uber.uberApp.entities.RideRequest;
import com.springboot.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {

   private final  ModelMapper modelMapper;


    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest= modelMapper.map(rideRequestDto, RideRequest.class);
        log.info(rideRequest.toString());
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RiderDto> getAllMyRides() {
        return List.of();
    }
}
