package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.example.LocationSystem.getCoords;

class LionPoint {
    String name;
    int gpsId;

    public LionPoint(String name, int gpsId) {
        this.name = name;
        this.gpsId = gpsId;
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




