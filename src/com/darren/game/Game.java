package com.darren.game;

import com.darren.game.actions.Action;

public class Game {
    public static void main(String[] args) {
        String[] inputCommands = {"PLACE 1,2,EAST", "RIGHT", "MOVE", "RIGHT", "REPORT"};

        Command command = new Command(inputCommands);
        Action.robot = new Robot();
        Action.map = new SquareMapSize5();
        Action[] actions = command.getActions();

        for (Action action: actions)
            action.on();
    }
}
