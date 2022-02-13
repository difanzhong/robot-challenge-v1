package com.darren.game.exceptions;

public class OutOfMapException extends Exception{
    public OutOfMapException() {
        super("Robot Position Out of Map. ");
    }

    public OutOfMapException(String message) {
        super(message);
    }
}
