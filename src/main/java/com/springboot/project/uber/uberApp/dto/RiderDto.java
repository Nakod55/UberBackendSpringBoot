package com.springboot.project.uber.uberApp.dto;

import com.springboot.project.uber.uberApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiderDto {
    private UserDto user;
    private Double rating;
}
