package com.example.Uber.service;

import com.example.Uber.exceptions.DriverAlreadyExistException;
import com.example.Uber.exceptions.DriverNotFoundException;
import com.example.Uber.models.Driver;
import com.example.Uber.models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService {
    Map<String, Driver> drivers = new HashMap<>();

    public void createDriver(Driver driver){
        if(drivers.containsKey(driver.getId())){
            throw new DriverAlreadyExistException("Driver already exist "+ driver.getId() + " name : "+ driver.getName());
        }
        drivers.put(driver.getId(), driver);
    }
    public Driver getDriverById(String id){
        if(!drivers.containsKey(id)){
            throw new DriverNotFoundException("Driver not found with id: "+ id);
        }
        return drivers.get(id);
    }
    public void updateDriverAvailability(String id, boolean newAvailability) {
        Driver driver = getDriverById(id);
        driver.setAcceptingRider(newAvailability);
    }
    public List<Driver> getAllNearByDriver(Location origin, double distance){
        List<Driver> nearByDriver = new ArrayList<>();
        for(Driver driver : drivers.values()){
            if(driver.getCurrentLocation().distanceBetweenLocation(origin) <= distance){
                nearByDriver.add(driver);
            }
        }
        return nearByDriver;
    }
}
