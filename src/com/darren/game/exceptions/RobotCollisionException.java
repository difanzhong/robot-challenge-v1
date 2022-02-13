package com.darren.game.exceptions;

import com.darren.game.GameRobot;

public class RobotCollisionException extends Exception{
    public RobotCollisionException() {
        super("Robot Collide with Another. ");
    }

    public RobotCollisionException(GameRobot robot) {
        super("Robot Collide with Another at " + robot.getCurrentPoint().toString());
    }
}
