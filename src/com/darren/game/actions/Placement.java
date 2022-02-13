package com.darren.game.actions;

import com.darren.game.exceptions.InvalidCommandException;

import java.awt.*;

public class Placement extends Action{
    private String[] robotInitialDataArray;

    public Placement(String actionName){
        name = actionName;
        robotInitialDataArray = getRobotInitialDataArrayBy(getSecondPartOfActionName());
    }

    @Override
    public void on() {
        try {
            printActionName();
            initializeRobot();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void initializeRobot() {
        try {
            if (!Action.map.isValidInitiation(robotInitialDataArray))
                throw new InvalidCommandException("Robot Initial Data Invalid.");

            Point initialPoint = new Point();
            initialPoint.setLocation(getX(robotInitialDataArray[0]), getY(robotInitialDataArray[1]));

            Byte directionIndex = Action.map.getDirectionIndexBy(robotInitialDataArray[2]);

            Action.robot.setCurrentPoint(initialPoint);
            Action.robot.setCurrentFacingDirectionIndex(directionIndex);
        } catch(InvalidCommandException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private double getX(String x) {
        return Double.parseDouble(x);
    }

    private double getY(String y) {
        return Double.parseDouble(y);
    }

    private String getSecondPartOfActionName() {
        return name.split(" ", -1)[1];
    }

    private String[] getRobotInitialDataArrayBy(String secondPartOfActionName) {
        return secondPartOfActionName.split(",", -1);
    }
}
