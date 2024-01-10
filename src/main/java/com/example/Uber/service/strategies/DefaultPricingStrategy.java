package com.example.Uber.service.strategies;

import com.example.Uber.models.Location;

public class DefaultPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Location origin, Location destination) {
        double distance = origin.distanceBetweenLocation(destination);

        return distance * AMOUNT_PER_KM;
    }
}
