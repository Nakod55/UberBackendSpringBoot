package com.springboot.project.uber.uberApp.controllers;

import com.springboot.project.uber.uberApp.dto.RideRequestDto;
import com.springboot.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

//    @RequestMapping(
//            value = "/rider/requestRide",
//            method = RequestMethod.POST,           // or POST, PUT, etc.
//            consumes = "application/json",
//            produces = "application/json"
//    )
@PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto){
        return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }
}
