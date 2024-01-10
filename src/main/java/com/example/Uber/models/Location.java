package com.example.Uber.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private double x;
    private double y;

    public double distanceBetweenLocation(Location location) {
        return Math.sqrt(Math.pow(this.x - location.x, 2) + Math.pow(this.y - location.y, 2));
    }
}
