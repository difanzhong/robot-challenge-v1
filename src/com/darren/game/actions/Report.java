package com.darren.game.actions;

import com.darren.game.nameObtainable;

public class Report extends Action{
    public Report(String actionName) {
        super.name = actionName;
    }

    @Override
    public void on() {
        try {
            printActionName();
            addLineSpace();
            printResult();
        } catch(Exception e) {
            System.out.println();
        }
    }

    private void printResult() {
        printOutputLabel();
        printIntegerRobotCurrentX();
        addComma();
        printIntegerRobotCurrentY();
        addComma();
        printRobotCurrentFaceDirectionName();
        addLineSpace();
    }

    private void printIntegerRobotCurrentX() {
        System.out.print((int)robot.getCurrentPoint().getX());
    }

    private void printIntegerRobotCurrentY(){
        System.out.print((int)robot.getCurrentPoint().getY());
    }

    private void printRobotCurrentFaceDirectionName() {
        nameObtainable[] directions = map.getDirections();
        System.out.print(directions[robot.getCurrentFacingDirectionIndex()].getName());
    }

    private void addLineSpace() {
        System.out.println();
    }

    private void addComma(){
        System.out.print(",");
    }

    private void printOutputLabel() {
        System.out.print("Output: ");
    }
}