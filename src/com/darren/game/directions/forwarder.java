package com.darren.game.directions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;

public interface forwarder {
    void forward(double steps, GameRobot robot, GameMap2D map);
}
