package com.example.Uber.service.strategies;

import com.example.Uber.models.Driver;

import java.util.List;

public class NearestDriverMatchingStrategy implements DriverMatchingStrategy{
    @Override
    public Driver findDriver(List<Driver> drivers) {

        return drivers != null ? drivers.get(0) : null;
        // through exception

    }
}
