package com.springboot.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointDto {
    private double[] coordinates;

    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }

    private String type= "Point";
}
