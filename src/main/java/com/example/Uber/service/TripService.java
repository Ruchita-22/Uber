package com.example.Uber.service;

import com.example.Uber.exceptions.TripAlreadyCompletedException;
import com.example.Uber.exceptions.TripNotFoundException;
import com.example.Uber.models.Driver;
import com.example.Uber.models.Location;
import com.example.Uber.models.Rider;
import com.example.Uber.models.Trip;
import com.example.Uber.models.enums.TripStatus;
import com.example.Uber.service.strategies.DefaultPricingStrategy;
import com.example.Uber.service.strategies.DriverMatchingStrategy;
import com.example.Uber.service.strategies.NearestDriverMatchingStrategy;
import com.example.Uber.service.strategies.PricingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripService {
    DriverService driverService;
    DriverMatchingStrategy driverMatchingStrategy;
    PricingStrategy pricingStrategy;
    Map<String, List<Trip>> trips = new HashMap();
    private static double MAXDistance = 10.0;
    // Rider id, Trip
    public TripService(DriverService driverService, NearestDriverMatchingStrategy nearestDriverStrategy, DefaultPricingStrategy defaultPricingStrategy){
        this.driverService = driverService;
        this.driverMatchingStrategy = nearestDriverStrategy;
        this.pricingStrategy = defaultPricingStrategy;
    }
    public void createTrip(Rider rider, Location origin, Location destination){
        List<Driver> drivers = driverService.getAllNearByDriver(origin,MAXDistance);
        drivers = drivers.stream().filter( driver ->  driver.isAvailable()).collect(Collectors.toList());
        Driver driver = driverMatchingStrategy.findDriver(drivers);

        double amount = pricingStrategy.calculatePrice(origin, destination);

        Trip trip = new Trip(origin, destination, 1, amount, driver, rider);

        if(!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList<>());
        }
        trips.get(rider.getId()).add(trip);

        driver.setCurrentTrip(trip);

    }
    public List<Trip> getTripHistory(Rider rider){
        return trips.get(rider.getId());
    }
    public void withdrawTrip(String id){
        Trip trip = getTripById(id);
        if(trip.getTripStatus() == TripStatus.COMPLETED) {
            throw new TripAlreadyCompletedException("Trip with trip id : "+id+" is already completed ");
        } else trip.setTripStatus(TripStatus.WITHDRAW);

        trip.getDriver().setCurrentTrip(null);
    }
    private Trip getTripById(String id){     // trip id
        return trips.values().stream().flatMap(
                list -> list.stream().filter(trip -> trip.getId().equals(id))
        ).findFirst().get();
    }
    public double endTrip(Driver driver) {
        if(driver.getCurrentTrip() == null) {
            throw new TripNotFoundException("Current driver dont have any trip");
        }
        double amount = driver.getCurrentTrip().getAmount();
        driver.getCurrentTrip().setTripStatus(TripStatus.COMPLETED);
        driver.setCurrentTrip(null);
        return  amount;
    }

}
