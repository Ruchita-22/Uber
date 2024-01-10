package com.example.Uber.service;

import com.example.Uber.exceptions.RiderNotFoundException;
import com.example.Uber.models.Rider;
import com.example.Uber.exceptions.RiderAlreadyExistException;

import java.util.HashMap;
import java.util.Map;

public class RiderService {
    Map<String, Rider> riders = new HashMap<>();
    public void createRider(Rider rider){
        if(riders.containsKey(rider.getId())){
            throw new RiderAlreadyExistException("Rider already exist "+ rider.getId() + " name : "+ rider.getName());
        }
        riders.put(rider.getId(), rider);
    }
    public Rider getRiderById(String id){
        if(!riders.containsKey(id)){
            throw new RiderNotFoundException("Rider not found with id: "+ id);
        }
        return riders.get(id);
    }
}
