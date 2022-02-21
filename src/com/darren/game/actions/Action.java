package com.darren.game.actions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;
import com.darren.game.nameObtainable;

import java.util.ArrayList;
import java.util.Hashtable;

abstract public class Action implements nameObtainable {
    String name;

    public static GameRobot robot;
    public static GameMap2D map;
    public static Hashtable<String, Action> commandActionTable;

    abstract public void on();

    public void printActionName() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }

    public static Action[] getActionsBy(String[] commands) {
        ArrayList<Action> actionList = new ArrayList<>();
        for (String command: commands) {
            Action action = command.contains("PLACE") ? new Placement(command) : commandActionTable.get(command);
            if (action != null) actionList.add(action);
        }
        return actionList.toArray(new Action[0]);
    }
}