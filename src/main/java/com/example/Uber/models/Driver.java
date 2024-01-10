package com.example.Uber.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Driver {
    private String id;
    private String name;
    private Location currentLocation;
    private Trip currentTrip;
    private boolean isAcceptingRider;


    public Driver(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
    public boolean isAvailable(){
        return this.currentTrip == null && this.isAcceptingRider;
    }

}
