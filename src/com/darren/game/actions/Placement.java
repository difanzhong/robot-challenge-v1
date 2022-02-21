package com.darren.game.actions;

import com.darren.game.exceptions.InvalidCommandException;
import com.darren.game.exceptions.InvalidRobotInitializationException;
import com.darren.game.nameObtainable;

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
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
//    private void initializeRobot() {
//        try {
//            if (!Action.map.isValidInitiation(robotInitialDataArray))
//                throw new InvalidCommandException("Robot Initial Data Invalid.");
//
//            Point initialPoint = new Point();
//            initialPoint.setLocation(getX(robotInitialDataArray[0]), getY(robotInitialDataArray[1]));
//
//            Byte directionIndex = Action.map.getDirectionIndexBy(robotInitialDataArray[2]);
//
//            Action.robot.setCurrentPoint(initialPoint);
//            Action.robot.setCurrentFacingDirectionIndex(directionIndex);
//        } catch(InvalidCommandException e) {
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public Point getRobotInitialPoint() throws InvalidRobotInitializationException {
        double x = Double.parseDouble(robotInitialDataArray[0]);
        double y = Double.parseDouble(robotInitialDataArray[1]);
        if (!map.isValidPointOnMap(x, y)) throw new InvalidRobotInitializationException("Invalid Robot Initial Point. ");

        Point initialPoint = new Point();
        initialPoint.setLocation(x, y);
        return initialPoint;
    }

    public byte getRobotInitialFaceDirectionIndex() throws InvalidRobotInitializationException{
        byte faceDirectionIndex = getFaceDirectionIndex(robotInitialDataArray[2]);
        if (!map.isValidDirectionIndex(faceDirectionIndex)) throw new InvalidRobotInitializationException("Invalid Robot Face Direction. ");
        return faceDirectionIndex;
    }

    private byte getFaceDirectionIndex(String Name) {
        nameObtainable[] directions = map.getDirections();
        for (byte i=0; i<directions.length; i++)
            if (directions[i].getName().equals(Name))
                return i;
        return -1;
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