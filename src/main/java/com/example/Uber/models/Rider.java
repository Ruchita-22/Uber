package com.example.Uber.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Rider {
    private String id;
    private String name;
    public Rider(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
