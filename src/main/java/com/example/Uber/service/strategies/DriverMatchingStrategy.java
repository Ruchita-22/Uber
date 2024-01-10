package com.example.Uber.service.strategies;

import com.example.Uber.models.Driver;

import java.util.List;

public interface DriverMatchingStrategy {
    public Driver findDriver(List<Driver> drivers);
}
