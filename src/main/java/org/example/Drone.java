package org.example;

import java.awt.*;

class Drone {
    String name;
    int gpsId;
    int frequency;

    public Drone(String name, int gpsId, int frequency) {
        this.name = name;
        this.gpsId = gpsId;
        this.frequency = frequency;
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