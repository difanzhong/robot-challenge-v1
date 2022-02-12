package com.darren.game.action;

public class Movement extends Action{
    private double steps;

    public Movement(String actionName, double stepsToMove) {
        super.name = actionName;
        this.steps = stepsToMove;
    }

    public void on() {

    }
}
