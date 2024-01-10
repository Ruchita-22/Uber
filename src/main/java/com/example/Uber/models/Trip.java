package com.example.Uber.models;

import com.example.Uber.models.enums.TripStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class Trip {
    private String id;
    private Location origin;
    private Location destination;
    private int noOfSeat;
    private TripStatus tripStatus;
    private double amount;
    private Driver driver;
    private Rider rider;

    public Trip(Location origin, Location destination, int noOfSeat, double amount, Driver driver, Rider rider) {
        this.id = UUID.randomUUID().toString();
        this.origin = origin;
        this.destination = destination;
        this.noOfSeat = noOfSeat;
        this.tripStatus = TripStatus.IN_PROGRESS;
        this.amount = amount;
        this.driver = driver;
        this.rider = rider;
    }

    public void withdrawTrip() {
        this.tripStatus = TripStatus.WITHDRAW;
    }

    public void completeTrip() {
        this.tripStatus = TripStatus.COMPLETED;
    }

    public void updateTrip(Location origin, Location destination, int noOfSeat, double amount) {
        this.origin = origin;
        this.destination = destination;
        this.noOfSeat = noOfSeat;
        this.amount = amount;
    }
}

