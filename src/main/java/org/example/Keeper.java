package org.example;

import java.awt.*;

class Keeper {
    String name;
    int gpsId;
    String phone;

    public Keeper(String name, int gpsId, String phone) {
        this.name = name;
        this.gpsId = gpsId;
        this.phone = phone;
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

