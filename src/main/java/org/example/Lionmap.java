package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.Graphics;

class Lionmap {
    public void displayLocations(List<Lion> lions, List<Keeper> keepers, List<Drone> drones) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel Lionpanel = new JPanel();
        Lionpanel.setLayout(null);

        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                for (Lion lion : lions) {
                    Point location = lion.getLocation();
                    g.setColor(Color.RED);
                    g.fillOval(location.x - 3, location.y - 3, 6, 6);
                    g.drawString(lion.name + " (Age: " + lion.age + ")", location.x + 5, location.y);
                }

                for (Keeper keeper : keepers) {
                    Point location = keeper.getLocation();
                    g.setColor(Color.BLUE);
                    g.fillOval(location.x - 2, location.y - 2, 4, 4);
                    g.drawString(keeper.name + " (Phone: " + keeper.phone + ")", location.x + 5, location.y);
                }

                for (Drone drone : drones) {
                    Point location = drone.getLocation();
                        g.setColor(Color.BLACK);
                        g.fillRect(location.x - 3, location.y - 3, 6, 6);
                        g.drawString(drone.name + " (Freq: " + drone.frequency + ")", location.x + 5, location.y);
                    }
                }
        };

        frame.add(canvas);
        frame.setVisible(true);
    }
}
