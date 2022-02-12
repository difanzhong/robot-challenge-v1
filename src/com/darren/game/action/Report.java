package com.darren.game.action;

public class Report extends Action{
    public Report(String actionName) {
        super.name = actionName;
    }

    public void on() {
        addLineSpace();
        printResult();
    }

    private void printResult() {
        printIntegerRobotCurrentX();
        addComma();
        addSpace();
        printIntegerRobotCurrentY();
        addComma();
        addSpace();
        printRobotCurrentFaceDirectionName();
    }

    private void printIntegerRobotCurrentX() {
        System.out.print((int)Action.robot.getCurrentPoint().getX());
    }

    private void printIntegerRobotCurrentY(){
        System.out.println((int)Action.robot.getCurrentPoint().getY());
    }

    private void printRobotCurrentFaceDirectionName() {

    }

    private void addLineSpace() {
        System.out.println();
    }

    private void addComma(){
        System.out.print(",");
    }

    private void addSpace() {
        System.out.print(" ");
    }

    private void printResultOfRobot() {

    }
}
