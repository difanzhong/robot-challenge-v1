package com.darren.game.exceptions;

public class InvalidRobotInitializationException extends Exception{
    public InvalidRobotInitializationException() {
        super("Robot Initialize Failed.");
    }

    public InvalidRobotInitializationException(String message) {
        super(message);
    }
}
