package com.example.Uber.service.strategies;

import com.example.Uber.models.Location;

import java.time.Instant;

public interface PricingStrategy {
     Integer AMOUNT_PER_KM = 20;
    public double calculatePrice(Location origin, Location destination);
}
