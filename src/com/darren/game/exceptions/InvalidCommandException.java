package com.darren.game.exceptions;

public class InvalidCommandException extends Exception{
    public InvalidCommandException() {
        super("Input Command is not Valid.");
    }

    public InvalidCommandException(String message) {
        super(message);
    }
}
