package com.darren.game.directions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;
import com.darren.game.nameObtainable;

abstract public class Direction implements forwarder, nameObtainable {
    protected String name;

    abstract public void forward(double steps, GameRobot robot, GameMap2D map);
    abstract public String getName();

    void printInvalidMoveMessage() {
        System.out.println(" (robot outside the map. Please ignore the above invalid action.) ");
    }
}
