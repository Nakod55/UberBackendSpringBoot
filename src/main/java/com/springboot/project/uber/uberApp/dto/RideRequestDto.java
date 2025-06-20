package com.springboot.project.uber.uberApp.dto;

import com.springboot.project.uber.uberApp.entities.enums.PaymentMethod;
import com.springboot.project.uber.uberApp.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.springboot.project.uber.uberApp.dto.PointDto;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;
    private PointDto pickUpLocation;
    private PointDto dropOffLocation;
    private LocalDateTime requestedTime;
    private RiderDto rider;
    private PaymentMethod paymentMethod;
    private RideRequestStatus rideRequestStatus;
}
