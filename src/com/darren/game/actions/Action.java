package com.darren.game.actions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;

abstract public class Action {
    String name;

    public static GameRobot robot;
    public static GameMap2D map;

    abstract public void on();

    void printActionName() {
        System.out.println(name);
    }

    public String getName() {
        return name;
    }
}
