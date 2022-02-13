package com.darren.game.actions;

import com.darren.game.directions.Direction;

public class Movement extends Action{
    private double steps;

    public Movement(String actionName, double stepsToMove) {
        super.name = actionName;
        this.steps = stepsToMove;
    }

    @Override
    public void on() {
        try {
            printActionName();
            move();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void move() {
        try {
            Direction facingDirection = Action.map.getDirectionBy(Action.robot.getCurrentFacingDirectionIndex());
            facingDirection.forward(steps, Action.robot, Action.map);
        } catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
