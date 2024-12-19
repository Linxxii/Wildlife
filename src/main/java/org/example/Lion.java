package org.example;

import org.example.LocationSystem;

import java.awt.*;

class Lion {
    String name;
    int gpsId;
    int age;

    public Lion(String name, int gpsId, int age) {
        this.name = name;
        this.gpsId = gpsId;
        this.age = age;
    }

    public Point getLocation() {
        try {
            return LocationSystem.getCoords(gpsId);
        } catch (Exception e) {
            System.out.println("Error retrieving location for " + name + ": " + e.getMessage());
        }
        return null;
    }
}