package org.example;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Lion simba = new Lion("Simba", 30, 7);
    static Keeper geoff = new Keeper("Geoff", 80, "4392");
    static Drone monitor1 = new Drone("Monitor1", 124, 128);

    public static void main(String[] args) {
        Lionmap map = new Lionmap();
        map.displayLocations(List.of(simba), List.of(geoff), List.of(monitor1));
        while (true) {
            checkProximity();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error in thread sleep: " + e.getMessage());
            }
        }
    }

    static void checkProximity() {
        Point simbaLocation = simba.getLocation();
        Point geoffLocation = geoff.getLocation();
        if (simbaLocation != null && geoffLocation != null) {
            float distance = (float) Math.hypot(simbaLocation.x - geoffLocation.x, simbaLocation.y - geoffLocation.y);
            if (distance < 60) {
                AlertSystem.alertAKeeper(geoff.phone);
                AlertSystem.alertADrone(monitor1.frequency);
            }
        }
    }
}