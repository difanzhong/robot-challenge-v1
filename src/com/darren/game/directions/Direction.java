package com.darren.game.directions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;

abstract public class Direction {
    protected String name;

    abstract public void forward(double steps, GameRobot robot, GameMap2D map);
    abstract public String getName();
}
