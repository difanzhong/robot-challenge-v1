package com.darren.game;

import com.darren.game.actions.*;
import com.darren.game.exceptions.InvalidRobotInitializationException;

import java.awt.*;
import java.util.Hashtable;

public class Game {
    public static void main(String[] args) {
//        String[] inputCommands = {"PLACE 1,2,EAST", "RIGHT", "MOVE", "RIGHT", "REPORT"};

//        Action.actionTable.put("Movement", new Movement());
        try {
            presetCommandActionTable();
            String[] commands = CommandManager.getCommandsFromFile("C:\\Users\\difan\\Desktop\\input.txt");

            Action.map = new SquareMapSize5();
            Action[] actions = Action.getActionsBy(commands);
            for (Action action : actions) {
                if ((action instanceof Placement)) {
                    initializeRobotWith((Placement) action);
                } else {
                    action.on();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void presetCommandActionTable() {
        Action.commandActionTable = new Hashtable<>();
        Action.commandActionTable.put("RIGHT", new RightTurn("RIGHT"));
        Action.commandActionTable.put("LEFT", new LeftTurn("LEFT"));
        Action.commandActionTable.put("MOVE", new Movement("MOVE", 1));
        Action.commandActionTable.put("REPORT", new Report("REPORT"));
    }

    static void initializeRobotWith(Placement placement) {
        try {
            Point initPoint = placement.getRobotInitialPoint();
            byte faceDirectionIndex = placement.getRobotInitialFaceDirectionIndex();
            Action.robot = new Robot(initPoint, faceDirectionIndex);
            placement.printActionName();
        } catch (InvalidRobotInitializationException e) {
            System.out.println(e.getMessage());
        }
    }
}
