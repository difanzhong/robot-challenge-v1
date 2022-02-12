package com.darren.game.action;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;

abstract public class Action {
    String name;

    static GameRobot robot;
    static GameMap2D map;

    abstract void on();
}
